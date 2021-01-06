package com.b3investbroker.service;


import com.b3investbroker.external.TicketGateway;
import com.b3investbroker.model.TicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketGateway gateway;

    public TicketVO findByName(final String name) {
        return gateway.findByName(name);
    }

    public List<TicketVO> findAll() {
        return gateway.findAll();
    }

}
