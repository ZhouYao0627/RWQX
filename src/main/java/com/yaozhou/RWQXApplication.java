package com.yaozhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class RWQXApplication {
    public static void main(String[] args) {
        SpringApplication.run(RWQXApplication.class, args);
        //System.out.println("success");
    }

    ///**
    // * 文件上传配置
    // *
    // * @return
    // */
    //@Bean
    //public MultipartConfigElement multipartConfigElement() {
    //    MultipartConfigFactory factory = new MultipartConfigFactory();
    //    //单个文件最大
    //    factory.setMaxFileSize(DataSize.parse("200MB")); //KB,MB
    //    /// 设置总上传数据总大小
    //    factory.setMaxRequestSize(DataSize.parse("400MB"));
    //    return factory.createMultipartConfig();
    //}

}
