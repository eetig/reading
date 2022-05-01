package com.eetig.reading.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Date 2022/4/9 周六 16:50
 * @Author xu
 * @FileName AccountApplication
 * @Description 账户模块入口
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.eetig.reading.account.dao")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
