package com.b3investoauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class B3investOauthApplication implements CommandLineRunner {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${oauth.client.name}")
    private String username;

    @Value("${oauth.client.secret}")
    private String secret;

    public static void main(final String[] args) {
        SpringApplication.run(B3investOauthApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("Getting config server configuration from username: {}, secret: {} and jwtSecret: {}", username, secret, jwtSecret);
    }
}
