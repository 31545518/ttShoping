package com.tt.order;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 * @Auther: blackcat
 * @Date: 2020-03-03
 * @Description: com.tt.order
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@EnableFeignClients
@MapperScan("com.tt.mapper")
public class FrontendOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendOrderApplication.class,args);
    }

}
