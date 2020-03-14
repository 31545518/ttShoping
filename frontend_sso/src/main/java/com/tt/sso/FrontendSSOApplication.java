package com.tt.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 用户用于登录服务
 * @Auther: blackcat
 * @Date: 2020-03-01
 * @Description: com.tt.sso
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.tt.mapper")
public class FrontendSSOApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendSSOApplication.class,args);
    }
}
