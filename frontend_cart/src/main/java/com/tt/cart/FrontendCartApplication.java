package com.tt.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 购物车启动类
 * @Auther: blackcat
 * @Date: 2020-02-29
 * @Description: com.tt.cart
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FrontendCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendCartApplication.class,args);
    }

}
