package com.zcdl.yjm_data_kafka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zcdl.yjm_data_kafka.mapper")
public class app {
    public static void main(String[] args) {
        SpringApplication.run(app.class,args);
    }
}
