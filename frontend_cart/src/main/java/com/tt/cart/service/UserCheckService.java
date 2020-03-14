package com.tt.cart.service;

import com.tt.pojo.TbUser;

/**
 * @Auther: blackcat
 * @Date: 2020-03-05
 * @Description: com.tt.cart.service.impl
 * @version:
 */
public interface UserCheckService {
    TbUser checkUserToken(String token);
}
