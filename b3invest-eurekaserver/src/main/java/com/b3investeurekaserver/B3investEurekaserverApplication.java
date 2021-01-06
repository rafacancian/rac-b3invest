package com.b3investeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class B3investEurekaserverApplication {

    public static void main(final String[] args) {
        SpringApplication.run(B3investEurekaserverApplication.class, args);
    }

}
