package com.dw.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置扫描mapper
@MapperScan("com.dw.sms.mapper")
public class SpringbootMybatisStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisStudyApplication.class, args);
    }

}
