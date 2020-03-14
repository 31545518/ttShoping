package com.tt.content;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableDistributedTransaction
public class BackendContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendContentApplication.class,args);
    }
}
