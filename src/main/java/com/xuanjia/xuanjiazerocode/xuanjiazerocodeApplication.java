package com.xuanjia.xuanjiazerocode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuanjia.xuanjiazerocode.mapper")
public class xuanjiazerocodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(xuanjiazerocodeApplication.class, args);
    }

}
