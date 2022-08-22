package com.yfk.yfwork.common;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName:service1Application
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/8 10:42
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yfk.yfwork.common.mapper")
@ComponentScan("com.yfk.yfwork.common.**")
public class CommonApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(CommonApplication.class, args);
    }
}
