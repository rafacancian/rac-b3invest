package com.b3investconfigserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@Slf4j
@EnableConfigServer
@SpringBootApplication
public class B3investConfigserverApplication implements CommandLineRunner {

    @Value("${spring.cloud.config.server.git.username}")
    private String username;

    @Value("${spring.cloud.config.server.git.default-label}")
    private String branch;

    public static void main(final String[] args) {
        SpringApplication.run(B3investConfigserverApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        log.info("Getting config server configuration from user: {} and branch: {}", username, branch);
    }
}
