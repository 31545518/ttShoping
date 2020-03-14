package com.tt.cart.service;

import com.tt.utils.Result;

/**
 * @Auther: blackcat
 * @Date: 2020-03-02
 * @Description: com.tt.cart.service
 * @version:
 */
public interface RedisCartService {
    Result addItem(Long itemId, Integer num, String userId);

    Result showCart(String userId);

    Result updateItemNum(Long itemId, Integer num, String userId);

    Result deleteItemFromCart(Long itemId, String userId);

    Result goSettlement(String[] ids, String userId);
}
