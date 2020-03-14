package com.tt.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 搜索服务
 * @Auther: blackcat
 * @Date: 2020-02-27
 * @Description: com.tt.search
 * @version:
 */
@SpringBootApplication
@MapperScan("com.tt.mapper")
public class FrontendSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontendSearchApplication.class,args);
    }
}
