package com.tt.content;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: blackcat
 * @Date: 2020-02-19
 * @Description: com.tt.content
 * @version:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
@MapperScan("com.tt.mapper")
public class CommonContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommonContentApplication.class,args);
    }
}
