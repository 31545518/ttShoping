package com.tt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式配置中心服务
 * @Auther: blackcat
 * @Date: 2020-03-07
 * @Description: com.tt.config
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class CommonConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonConfigApplication.class,args);
    }

}
