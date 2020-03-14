package com.tt.item;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: blackcat
 * @Date: 2020-01-13
 * @Description: com.tt.item
 * @version:
 * 通用服务Common_item
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@MapperScan("com.tt.mapper")
public class CommonItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonItemApplication.class,args);
    }
}
