package com.atguigu.gmall1122.publisher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.gmall1122.publisher.mapper")
public class Gmall1122PublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(Gmall1122PublisherApplication.class, args);
    }

}
