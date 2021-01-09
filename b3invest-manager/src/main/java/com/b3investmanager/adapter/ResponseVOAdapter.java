package com.b3investmanager.adapter;

import com.b3investmanager.model.ResponseVO;
import com.b3investmanager.model.TicketVO;
import org.springframework.hateoas.Links;

import java.util.List;

public class ResponseVOAdapter {

    public static ResponseVO create(List<TicketVO> tickets, Links links) {
        return ResponseVO.builder().tickets(tickets).links(links).build();
    }
}
