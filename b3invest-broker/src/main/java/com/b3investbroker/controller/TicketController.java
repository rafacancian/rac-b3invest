package com.b3investbroker.controller;


import com.b3investbroker.exception.ControllerException;
import com.b3investbroker.model.ResponseVO;
import com.b3investbroker.model.TicketVO;
import com.b3investbroker.service.TicketService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<?> findAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") final int page,
            @RequestParam(value = "page-size", required = false, defaultValue = "10") final int size) {
        final ResponseVO responseVO = ticketService.findAll(page, size);
        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }

    public static ResponseEntity<?> findByNameFallBack(final String name) {
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

    public static ResponseEntity<?> findAllFallBack(final int page, final int size) {
        return new ResponseEntity<>(null, HttpStatus.REQUEST_TIMEOUT);
    }

}
