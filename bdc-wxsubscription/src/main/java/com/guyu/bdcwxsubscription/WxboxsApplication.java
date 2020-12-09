package com.guyu.bdcwxsubscription;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.guyu.bdcwxsubscription.mapper")
@EnableScheduling
@ServletComponentScan
public class WxboxsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxboxsApplication.class, args);
    }

}
