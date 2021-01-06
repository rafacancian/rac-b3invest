package com.b3investbroker.controller;


import com.b3investbroker.exception.ControllerException;
import com.b3investbroker.model.TicketVO;
import com.b3investbroker.service.TicketService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController extends ControllerException {

    private final TicketService ticketService;

    @HystrixCommand(fallbackMethod = "findByNameFallBack")
    @GetMapping(value = "/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findByName(@PathVariable("name") final String name) {
        log.debug("Receiving parameters to find ticket by name: {}", name);
        final TicketVO ticketVO = ticketService.findByName(name);
        return new ResponseEntity<>(ticketVO, HttpStatus.OK);
    }

    @HystrixCommand(fallbackMethod = "findAllFallBack")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findAll() {
        final List<TicketVO> ticketVOs = ticketService.findAll();
        return new ResponseEntity<>(ticketVOs, HttpStatus.OK);
    }

    public static ResponseEntity<?> findByNameFallBack(final String name) {
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

    public static ResponseEntity<?> findAllFallBack() {
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

}
