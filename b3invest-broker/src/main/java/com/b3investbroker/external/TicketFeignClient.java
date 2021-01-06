package com.b3investbroker.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "b3invest-manager", path = "/ticket")
public interface TicketFeignClient {

    @GetMapping(value = "/{name}")
    ResponseEntity<?> findByName(@PathVariable("name") final String name);

    @GetMapping()
    ResponseEntity<?> findAll();
}
