package com.tt.sso.controller;

import com.tt.pojo.TbUser;
import com.tt.sso.service.SSOService;
import com.tt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: blackcat
 * @Date: 2020-03-01
 * @Description: com.tt.sso.controller
 * @version:
 */
@RestController
@RequestMapping("/sso")
@RefreshScope
public class SSOController {

    @Autowired
    private SSOService ssoService;

    /**
     * 对用户注册信息（用户名和电话号码）做数据校验
     * @param checkValue
     * @param checkFlag
     * @return
     */
    @RequestMapping("/checkUserInfo/{checkValue}/{checkFlag}")
    public Result checkUserInfo(@PathVariable String checkValue,@PathVariable Integer checkFlag){
        try {
            return this.ssoService.checkUserInfo(checkValue,checkFlag);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/userRegister")
    public Result userRegister(TbUser user){
        try {
            return this.ssoService.userRegister(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/userLogin")
    public Result userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response){
        try {
            return this.ssoService.userLogin(username,password,request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

    @RequestMapping("/logOut")
    public Result logOut(String token){
        try {
            return this.ssoService.logOut(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.build(500,"ERROR");
    }

}
