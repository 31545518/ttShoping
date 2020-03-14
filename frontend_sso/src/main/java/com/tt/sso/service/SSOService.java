package com.tt.sso.service;

import com.tt.pojo.TbUser;
import com.tt.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: blackcat
 * @Date: 2020-03-01
 * @Description: com.tt.sso.service
 * @version:
 */
public interface SSOService {
    Result checkUserInfo(String checkValue, Integer checkFlag);

    Result userRegister(TbUser user);

    Result userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);

    Result logOut(String token);
}
