package com.tt.cart.controller;

import com.tt.cart.service.CookieCartService;
import com.tt.cart.service.RedisCartService;
import com.tt.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.cart.controller
 * @version:
 */
@RestController
@RequestMapping("/cart")
@RefreshScope
public class CartController {

    @Autowired
    private CookieCartService cookieCartService;
    @Autowired
    private RedisCartService redisCartService;

    @RequestMapping("/addItem")
    public Result addItem(Long itemId , String userId, @RequestParam(defaultValue = "1") Integer num, HttpServletRequest request, HttpServletResponse response){
        try {

            if (StringUtils.isBlank(userId)){
                // 用户未登录的状态下
                return cookieCartService.addItem(itemId,num,request,response);

            } else {
                // 用户已登录的状态下
                return this.redisCartService.addItem(itemId,num,userId);
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.build(500,"ERROR");
    }

    /**
     * 查看购物车
     * @param userId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/showCart")
    public Result showCart(String userId,HttpServletRequest request,HttpServletResponse response){
        try {
            if (StringUtils.isBlank(userId)){
                // 用户未登录的状态下
                return this.cookieCartService.showCart(request,response);
            }else {
                // 用已登录的状态
                return this.redisCartService.showCart(userId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 修改购物车数量
     * @param itemId
     * @param userId
     * @param num
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/updateItemNum")
    public Result updateItemNum(Long itemId,String userId,Integer num,HttpServletRequest request,HttpServletResponse response){
        try {
            if (StringUtils.isBlank(userId)){
                // 用户在未登录状态下
                return this.cookieCartService.updateItemNum(itemId,num,request,response);
            } else {
                // 用户在已登录状态
                return this.redisCartService.updateItemNum(itemId,num,userId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    @RequestMapping("/deleteItemFromCart")
    public Result deleteItemFromCart(@RequestParam Long itemId,@RequestParam String userId,HttpServletRequest request,HttpServletResponse response){
        try {
            if (StringUtils.isBlank(userId)){
                // 用户在未登录状态下
                return this.cookieCartService.deleteItemFromCart(itemId,request,response);
            } else {
                // 用户在已登录状态
                return this.redisCartService.deleteItemFromCart(itemId,userId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return Result.build(500,"ERROR");
    }

    @RequestMapping("/goSettlement")
    public Result goSettlement(String userId,String []ids){
        try {
            return this.redisCartService.goSettlement(ids,userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

}
