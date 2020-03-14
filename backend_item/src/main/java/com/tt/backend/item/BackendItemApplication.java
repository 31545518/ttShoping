package com.tt.backend.item;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Auther: blackcat
 * @Date: 2020-01-14
 * @Description: com.tt.backend.item
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@EnableFeignClients
public class BackendItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendItemApplication.class,args);
    }
}
