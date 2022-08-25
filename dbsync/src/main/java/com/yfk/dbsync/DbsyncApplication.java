package com.yfk.dbsync;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.yfk.dbsync.mapper")
@ComponentScan("com.yfk.dbsync.**")
public class DbsyncApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbsyncApplication.class, args);
    }

}
