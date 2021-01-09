package com.b3investmanager.adapter;

import com.b3investmanager.entity.Ticket;
import com.b3investmanager.model.TicketVO;
import org.modelmapper.ModelMapper;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class TicketVOAdapter {

    public static TicketVO create(final Ticket ticket) {
        if (!ObjectUtils.isEmpty(ticket)) {
            return new ModelMapper().map(ticket, TicketVO.class);
        }
        return TicketVO.builder().build();
    }

    public static List<TicketVO> create(final List<Ticket> tickets) {
        final List<TicketVO> ticketVOs = new ArrayList<>();
        if (!ObjectUtils.isEmpty(tickets)) {
            tickets.stream().forEach(t -> {
                ticketVOs.add(new ModelMapper().map(t, TicketVO.class));
            });
        }
        return ticketVOs;
    }
}
