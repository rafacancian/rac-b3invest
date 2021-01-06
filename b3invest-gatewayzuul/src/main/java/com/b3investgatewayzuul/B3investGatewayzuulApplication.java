package com.b3investgatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class B3investGatewayzuulApplication {

    public static void main(final String[] args) {
        SpringApplication.run(B3investGatewayzuulApplication.class, args);
    }

}
