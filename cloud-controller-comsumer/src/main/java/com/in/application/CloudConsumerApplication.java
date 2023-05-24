package com.in.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * @author: yingjf
 * @date: 2023/5/23 11:10
 * @description:
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.in"})
public class CloudConsumerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(CloudConsumerApplication.class, args);
        } catch (Exception e) {
            log.error("CloudConsumerApplication启动失败", e);
        }
    }
}
