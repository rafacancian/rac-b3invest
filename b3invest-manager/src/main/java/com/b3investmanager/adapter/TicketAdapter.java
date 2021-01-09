package com.b3investmanager.adapter;

import com.b3investmanager.entity.Ticket;
import com.b3investmanager.model.TicketVO;
import org.modelmapper.ModelMapper;

public class TicketAdapter {

    public static Ticket create(TicketVO ticketVO) {
        return new ModelMapper().map(ticketVO, Ticket.class);
    }

}
