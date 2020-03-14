package com.tt.sso.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.tt.mapper.TbUserMapper;
import com.tt.pojo.TbUser;
import com.tt.pojo.TbUserExample;
import com.tt.sso.feign.CommonRedisFeignClient;
import com.tt.sso.service.SSOService;
import com.tt.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Auther: blackcat
 * @Date: 2020-03-01
 * @Description: com.tt.sso.service.impl
 * @version:
 */
@Service
public class SSOServiceImpl implements SSOService {

    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private CommonRedisFeignClient commonRedisFeignClient;
    @Value("cart_cookie_name")
    private String cart_cookie_name;


    /**
     * 对用户注册信息做数据校验
     * @param checkValue
     * @param checkFlag
     * @return
     */
    @Override
    public Result checkUserInfo(String checkValue, Integer checkFlag) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        if (checkFlag == 1){
            criteria.andUsernameEqualTo(checkValue);
        } else if (checkFlag == 2){
            criteria.andPhoneEqualTo(checkValue);
        }
        int count = this.tbUserMapper.countByExample(example);
        if (count > 0){
            return Result.error("数据不可用");
        }

        return Result.ok(checkValue);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    @LcnTransaction
    public Result userRegister(TbUser user) {
        // 将密码做加密处理
        String pwd = MD5Utils.digest(user.getPassword());
        user.setPassword(pwd);

        user.setCreated(new Date());
        user.setUpdated(new Date());
        this.tbUserMapper.insert(user);
        return Result.ok();
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Result userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        //根据用户名和密码查询数据库
        TbUser tbUser = this.login(username,password);
        if (tbUser == null){
            return Result.error("用户名或密码有误，请从新输入");
        }
        //将用户加到Redis中
        String userToken = UUID.randomUUID().toString();
        Integer flag = this.insertUserToRedis(tbUser,userToken);
        if (flag == 500){
            return Result.error("登录失败");
        }
        Map<String,String>map = new HashMap<>();
        map.put("token",userToken);
        map.put("userid",tbUser.getId().toString());
        map.put("username",tbUser.getUsername());

        // 将临时购物车中的商品同步到永久购物车中
        this.syncCart(tbUser.getId().toString(),request);
        // 同步购物车成功后，需要将临时购物车中的商品删除掉
        this.deleteCookieCart(request,response);

        return Result.ok(map);
    }

    /**
     * 删除临时购物车
     * @param request
     * @param response
     */
    private void deleteCookieCart(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request,response,this.cart_cookie_name);
    }

    /**
     * 同步购物车
     * @param userId
     * @param request
     */
    private void syncCart(String userId, HttpServletRequest request) {
        // 获取临时购物车
        Map<String, CartItem> cookieCart = this.getCart(request);

        // 获取永久购物车
        Map<String, CartItem> redisCart = this.getCart(userId);

        // 删除永久购物车中所包含临时购物车中的商品
        Set<String> keys = cookieCart.keySet();
        for (String key : keys){
            redisCart.remove(key);
        }
        // 将同步后的购物车缓存到redis中
        redisCart.putAll(cookieCart);
        // 将永久购物车重新缓存到redis中
        this.addCart2Redis(userId,redisCart);


    }

    /**
     * 将永久购物车重新缓存到redis中
     * @param userId
     * @param cart
     */
    private void  addCart2Redis(String userId, Map<String, CartItem> cart) {
        Map <String ,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("cart",cart);
        this.commonRedisFeignClient.insertCart(map);
    }

    /**
     * 获取永久购物车
     * @param userId
     * @return
     */
    private Map<String, CartItem> getCart(String userId) {
        try {
            Map<String, CartItem> cart = this.commonRedisFeignClient.selectCartByUserId(userId);
            if (cart == null){
                cart = new HashMap<String, CartItem>();
            }
            return cart;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new HashMap<String, CartItem>();
    }

    /**
     * 获取临时购物车
     * @param request
     * @return
     */
    private Map<String, CartItem> getCart(HttpServletRequest request) {
        // 获取已存在的临时购物车
        String cartJson = CookieUtils.getCookieValue(request, this.cart_cookie_name, true);
        if(StringUtils.isBlank(cartJson)){
            // 临时购物车不存在
            return new HashMap<String,CartItem>();
        }
        try {
            // 如果含有临时购物车，需要json转换
            Map map = JsonUtils.jsonToMap(cartJson, CartItem.class);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }

        return new HashMap<String,CartItem>();

    }



    /**
     * 用户退出登录
     * @param token
     * @return
     */
    @Override
    public Result logOut(String token) {
        this.commonRedisFeignClient.logOut(token);
        return Result.ok();
    }

    /**
     * 将用户添加到Redis中
     * @param tbUser
     * @param userToken
     * @return
     */
    private Integer insertUserToRedis(TbUser tbUser, String userToken) {
        try {
            this.commonRedisFeignClient.insertUser(tbUser,userToken);
            return 200;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 500;
    }

    /**
     * 用户登录业务处理
     * @param username
     * @param password
     * @return
     */
    private TbUser login(String username, String password) {
        String pwd = MD5Utils.digest(password);
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(pwd);
        List<TbUser> list = this.tbUserMapper.selectByExample(example);
        if (list == null || list.size()<=0){
            return  null;
        }
        return list.get(0);
    }
}
