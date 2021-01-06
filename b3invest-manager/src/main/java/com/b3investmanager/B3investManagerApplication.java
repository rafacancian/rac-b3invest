package com.b3investmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class B3investManagerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(B3investManagerApplication.class, args);
    }

}
