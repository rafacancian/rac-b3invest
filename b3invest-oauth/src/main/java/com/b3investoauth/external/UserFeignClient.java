package com.b3investoauth.external;

import com.b3investoauth.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(name = "b3invest-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<?> findById(@PathVariable("id") final String name);

    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam String email);
}

