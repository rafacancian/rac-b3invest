package com.b3investbroker.external;

import com.b3investbroker.model.TicketVO;

import java.util.List;

public interface TicketGateway {

    TicketVO findByName(String name);

    List<TicketVO> findAll();
}
