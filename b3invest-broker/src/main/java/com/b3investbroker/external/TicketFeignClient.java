package com.b3investbroker.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "b3invest-manager", path = "/ticket")
public interface TicketFeignClient {

    @GetMapping(value = "/{name}")
    ResponseEntity<?> findByName(@PathVariable("name") final String name);

    @GetMapping()
    ResponseEntity<?> findAll(@RequestParam("page") final int page, @RequestParam("page-size") final int size);
}
