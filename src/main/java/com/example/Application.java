package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, JmsAutoConfiguration.class})
@ComponentScan(basePackages = "com.example")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
