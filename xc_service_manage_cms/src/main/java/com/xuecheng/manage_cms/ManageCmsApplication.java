package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.xuecheng.framework.domain.cms")
@ComponentScan(basePackages = {"com.xuecheng.api","com.xuecheng.manage_cms"})
public class ManageCmsApplication {
    public static void main(String[] args) {

        SpringApplication.run(ManageCmsApplication.class,args);
    }
}
