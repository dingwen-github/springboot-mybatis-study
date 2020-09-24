package com.dw.sms.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @program:
 * @description: 文件上传下载配置类
 * @author: dingwen
 * @create: 2020/9/24 14:24
 **/
@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //配置文件大小限制，超出范围抛出异常信息
        factory.setMaxFileSize(DataSize.parse("2MB"));
        //设置总上传数据大小
        factory.setMaxRequestSize(DataSize.parse("20MB"));
        //设置文件临时文件夹路径
        factory.setLocation("E:/study/springboot-mybatis-study/files");
        return factory.createMultipartConfig();
    }
}
