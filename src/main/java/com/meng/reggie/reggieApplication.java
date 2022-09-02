package com.meng.reggie;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication()
public class reggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(reggieApplication.class,args);
        log.info("梦启动");
    }
}
