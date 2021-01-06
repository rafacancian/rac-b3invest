package com.b3investbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name = "b3invest-manager")
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class B3investBrokerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(B3investBrokerApplication.class, args);
    }

}
