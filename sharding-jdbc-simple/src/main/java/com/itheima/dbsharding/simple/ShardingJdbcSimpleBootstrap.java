package com.itheima.dbsharding.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(exclude = SpringBootConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ShardingJdbcSimpleBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcSimpleBootstrap.class, args);
    }

}
