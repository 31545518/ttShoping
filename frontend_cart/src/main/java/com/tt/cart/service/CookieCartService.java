package com.tt.cart.service;

import com.tt.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车在未登录状态下
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.cart.service
 * @version:
 */
public interface CookieCartService {
    Result addItem(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);

    Result showCart(HttpServletRequest request, HttpServletResponse response);

    Result updateItemNum(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response);

    Result deleteItemFromCart(Long itemId, HttpServletRequest request, HttpServletResponse response);
}
