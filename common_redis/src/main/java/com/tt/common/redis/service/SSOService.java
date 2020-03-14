package com.tt.common.redis.service;

import com.tt.pojo.TbUser;

/**
 * @Auther: blackcat
 * @Date: 2020-03-01
 * @Description: com.tt.common.redis.service
 * @version:
 */
public interface SSOService {
    void insertUser(TbUser tbUser, String userToken);

    void logOut(String userToken);

    TbUser checkUserToken(String token);
}
