package com.example.vblogservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.vblogservice.mapper")
public class VblogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VblogServiceApplication.class, args);
    }

}
