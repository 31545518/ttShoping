package com.tt.common.redis.controller;

import com.tt.common.redis.service.SSOService;
import com.tt.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 缓存用户Controller
 * @Auther: blackcat
 * @Date: 2020-03-01
 * @Description: com.tt.common.redis.controller
 * @version:
 */
@RestController
@RequestMapping("/sso/redis")
@RefreshScope
public class SSOController {

    @Autowired
    private SSOService ssoService;

    @RequestMapping("/insertUser")
    public void insertUser(@RequestBody TbUser tbUser, @RequestParam String userToken){
        this.ssoService.insertUser(tbUser,userToken);
    }

    /**
     * 用户退出登录
     * @param userToken
     */
    @RequestMapping("/logOut")
    public void logOut(@RequestParam String userToken){
        this.ssoService.logOut(userToken);
    }

    @RequestMapping("checkUserToken")
    public TbUser checkUserToken(@RequestParam String token){
        return this.ssoService.checkUserToken(token);
    }


}
