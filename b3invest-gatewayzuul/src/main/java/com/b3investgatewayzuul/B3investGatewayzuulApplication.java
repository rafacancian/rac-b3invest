package com.b3investgatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
@EnableSwagger2
public class B3investGatewayzuulApplication {

    public static void main(final String[] args) {
        SpringApplication.run(B3investGatewayzuulApplication.class, args);
    }

}
