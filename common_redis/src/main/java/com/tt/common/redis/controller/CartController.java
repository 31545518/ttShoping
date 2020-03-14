package com.tt.common.redis.controller;

import com.tt.common.redis.service.CartService;
import com.tt.utils.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 购物车操作
 * @Auther: blackcat
 * @Date: 2020-03-02
 * @Description: com.tt.common.redis.controller
 * @version:
 */
@RestController
@RequestMapping("/redis/cart")
@RefreshScope
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加购物车信息
     * @param map
     */
    @RequestMapping("/insertCart")
    public void insertCart(@RequestBody Map<String,Object> map){
        this.cartService.insertCart(map);
    }

    /**
     * 根据用户ID查询用户购物车
     * @param userId
     * @return
     */
    @RequestMapping("/selectCartByUserId")
    public Map<String, CartItem> selectCartByUserId(@RequestParam String userId){
        return this.cartService.selectCartByUserId(userId);
    }

}
