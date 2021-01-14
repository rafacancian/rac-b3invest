package com.b3investbroker.external;

import com.b3investbroker.model.ResponseVO;
import com.b3investbroker.model.TicketVO;

public interface TicketGateway {

    TicketVO findByName(String name);

    ResponseVO findAll(int page, int size);
}
