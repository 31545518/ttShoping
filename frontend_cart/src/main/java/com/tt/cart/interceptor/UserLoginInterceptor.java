package com.tt.cart.interceptor;

import com.tt.cart.service.UserCheckService;
import com.tt.pojo.TbUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断结算之前用户是否登录拦截器
 * @Auther: blackcat
 * @Date: 2020-03-05
 * @Description: com.tt.cart.interceptor
 * @version:
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserCheckService userCheckService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 对用户的token做判断
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            return false;
        }
        // 如果用户token不为空，则校验用户在redis中是否失效
        TbUser tbUser = this.userCheckService.checkUserToken(token);
        if (tbUser == null){
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
