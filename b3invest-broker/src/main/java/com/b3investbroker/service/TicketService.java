package com.b3investbroker.service;


import com.b3investbroker.external.TicketGateway;
import com.b3investbroker.model.ResponseVO;
import com.b3investbroker.model.TicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketGateway gateway;

    public TicketVO findByName(final String name) {
        return gateway.findByName(name);
    }

    public ResponseVO findAll(int page, int size) {
        return gateway.findAll(page, size);
    }

}
