package com.b3investoauth.controller;


import com.b3investoauth.entity.User;
import com.b3investoauth.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam final String email) {
        try {
            log.info("UserResource findByEmail: {}", email);
            final User user = service.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (final IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/test")
    public static ResponseEntity<User> findTest() {
        log.info("UserResource findTest");
        try {
            return ResponseEntity.ok(null);
        } catch (final IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}