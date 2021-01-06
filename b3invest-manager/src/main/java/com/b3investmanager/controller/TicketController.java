package com.b3investmanager.controller;

import com.b3investmanager.exception.ControllerException;
import com.b3investmanager.model.TicketVO;
import com.b3investmanager.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController extends ControllerException {

    private final TicketService ticketService;

    @Autowired
    private final Environment environment;

    @GetMapping(value = "/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findByName(@PathVariable("name") final String name) {
        log.debug("Receiving parameters to find ticket by name: {}", name);
        log.info("Server Port: {}", environment.getProperty("local.server.port"));
        final TicketVO ticketVO = ticketService.findByName(name);
        return new ResponseEntity<>(ticketVO, HttpStatus.OK);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> findAll() {
        final List<TicketVO> ticketVOs = ticketService.findAll();
        return new ResponseEntity<>(ticketVOs, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> create(@RequestBody final TicketVO ticketVO) {
        final TicketVO ticketVOCreated = ticketService.create(ticketVO);
        return new ResponseEntity<>(ticketVOCreated, HttpStatus.CREATED);
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> update(@RequestBody final TicketVO ticketVO) {
        final TicketVO ticketVODeleted = ticketService.update(ticketVO);
        return new ResponseEntity<>(ticketVODeleted, HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> delete(@PathVariable("name") final String name) {
        ticketService.delete(name);
        return ResponseEntity.ok().build();
    }

}
