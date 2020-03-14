package com.tt.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: blackcat
 * @Date: 2020-03-05
 * @Description: com.tt.zuul
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CommonZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonZuulApplication.class,args);
    }

}
