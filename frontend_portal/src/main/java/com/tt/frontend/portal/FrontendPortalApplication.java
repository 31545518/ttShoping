package com.tt.frontend.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务启动类
 * @Auther: blackcat
 * @Date: 2020-02-24
 * @Description: com.tt.frontend.portal
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FrontendPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendPortalApplication.class,args);
    }
}
