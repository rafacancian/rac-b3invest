package com.b3investmanager.adapter;

import com.b3investmanager.model.LinksVO;
import com.b3investmanager.model.ResponseVO;
import com.b3investmanager.model.TicketVO;

import java.util.List;

public class ResponseVOAdapter {

    public static ResponseVO create(List<TicketVO> tickets, LinksVO links) {
        return ResponseVO.builder().tickets(tickets).linksVo(links).build();
    }
}
