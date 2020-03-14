package com.tt.common.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: blackcat
 * @Date: 2020-02-25
 * @Description: com.tt.common.redis
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CommonRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonRedisApplication.class,args);
    }
}
