package com.in.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: yingjf
 * @date: 2023/5/23 19:30
 * @description:
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.in"})
public class CloudProducerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(CloudProducerApplication.class, args);
        }catch (Exception e){
            log.error("",e);
        }

    }
}
