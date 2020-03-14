package com.tt.cart.service.impl;

import com.tt.cart.feign.CommonRedisFeignClient;
import com.tt.cart.service.UserCheckService;
import com.tt.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: blackcat
 * @Date: 2020-03-05
 * @Description: com.tt.cart.service.impl
 * @version:
 */
@Service
public class UserCheckServiceImpl implements UserCheckService {
    @Autowired
    private CommonRedisFeignClient commonRedisFeignClient;

    @Override
    public TbUser checkUserToken(String token) {
        return this.commonRedisFeignClient.checkUserToken(token);
    }
}
