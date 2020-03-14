package com.tt.cart.service.impl;

import com.tt.cart.feign.CommonItemFeignClient;
import com.tt.cart.service.CookieCartService;
import com.tt.pojo.TbItem;
import com.tt.utils.CartItem;
import com.tt.utils.CookieUtils;
import com.tt.utils.JsonUtils;
import com.tt.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 用户未登录购物车下的操作业务
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.cart.service.impl
 * @version:
 */
@Service
public class CookieCartServiceImpl implements CookieCartService {

    @Value("cart_cookie_name")
    private String cart_cookie_name;

    @Autowired
    private CommonItemFeignClient commonItemFeignClient;


    /**
     * 将商品添加到购物车中
     * @param itemId
     * @param num
     * @param request
     * @param response
     * @return
     */
    @Override
    public Result addItem(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
        // 1.获取临时购物车
        Map<String, CartItem>cart = this.getCart(request);
        // 2.查询商品
        TbItem item = this.getSelectItemById(itemId);
        // 3.向购物车中添加商品
        this.addItem2Cart(cart,item,num,itemId);
        // 4.将添加的购物车通过Cookie写回给客户端浏览器
        this.addClientCookie(request,response,cart);
        return Result.ok();
    }

    /**
     * 查看购物车
     * @param request
     * @param response
     * @return
     */
    @Override
    public Result showCart(HttpServletRequest request, HttpServletResponse response) {
        List<CartItem>list = new ArrayList<>();
        Map<String, CartItem> cart = this.getCart(request);
        Set<String> keySet = cart.keySet();
        for (String key : keySet){
            list.add(cart.get(key));
        }

        return Result.ok(list);
    }

    /**
     * 修改购物车数量
     * @param itemId
     * @param num
     * @param request
     * @param response
     * @return
     */
    @Override
    public Result updateItemNum(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
        Map<String,CartItem>cart = this.getCart(request);
        CartItem cartItem = cart.get(itemId.toString());
        if (cartItem != null){
            cartItem.setNum(num);
        }
        this.addClientCookie(request,response,cart);

        return Result.ok();
    }

    /**
     * 删除购物车商品
     * @param itemId
     * @param request
     * @param response
     * @return
     */
    @Override
    public Result deleteItemFromCart(Long itemId, HttpServletRequest request, HttpServletResponse response) {
        Map<String, CartItem> cart = this.getCart(request);
        cart.remove(itemId.toString());
        this.addClientCookie(request,response,cart);;

        return Result.ok();
    }

    /**
     * 将添加的购物车通过Cookie写回给客户端浏览器
     * @param request
     * @param response
     * @param cart
     */
    private void addClientCookie(HttpServletRequest request, HttpServletResponse response, Map<String, CartItem> cart) {
        String cartJson = JsonUtils.objectToJson(cart);
        CookieUtils.setCookie(request,response,this.cart_cookie_name,cartJson,true);
    }

    /**
     * 将商品添加到购物车中
     * @param cart
     * @param item
     * @param num
     * @param itemId
     */
    private void addItem2Cart(Map<String, CartItem> cart, TbItem item, Integer num, Long itemId) {
        // 从购物车中取商品
        CartItem cItem = cart.get(itemId.toString());
        if (cItem == null){
            // 没有相同的商品
            CartItem cartItem = new CartItem();
            cartItem.setId(item.getId());
            cartItem.setImage(item.getImage());
            cartItem.setNum(num);
            cartItem.setPrice(item.getPrice());
            cartItem.setSellPoint(item.getSellPoint());
            cartItem.setTitle(item.getTitle());
            cart.put(item.getId().toString(),cartItem);
        }else {
            cItem.setNum(cItem.getNum()+num);
        }

    }

    /**
     * 根据商品ID查询商品
     * @param itemId
     * @return
     */
    private TbItem getSelectItemById(Long itemId) {
        TbItem item = commonItemFeignClient.selectItemInfo(itemId);
        return item;
    }

    /**
     * 获取购物车
     * @param request
     * @return
     */
    private Map<String, CartItem> getCart(HttpServletRequest request) {
        // 获取已存在的临时购物车
        String cartJson = CookieUtils.getCookieValue(request, this.cart_cookie_name, true);
        if (StringUtils.isBlank(cartJson)){
            // 不存在临时购物车，就创建一个
            return new HashMap<String,CartItem>();
        }

        try {
            // 如果还有临时购物车，那么需要做Json转换
            Map<String,CartItem>map = JsonUtils.jsonToMap(cartJson,CartItem.class);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new HashMap<String,CartItem>();

    }
}
