package com.tt.common.redis.service;

import com.tt.utils.CartItem;

import java.util.Map;

/**
 * @Auther: blackcat
 * @Date: 2020-03-02
 * @Description: com.tt.common.redis.service
 * @version:
 */
public interface CartService {
    void insertCart(Map<String, Object> map);

    Map<String, CartItem> selectCartByUserId(String userId);
}
