package com.b3investmanager.service;

import com.b3investmanager.entity.Ticket;
import com.b3investmanager.exception.EntityNotFoundException;
import com.b3investmanager.external.TicketGateway;
import com.b3investmanager.model.TicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketGateway gateway;

    public TicketVO findById(final Long id) {
        final Optional<Ticket> ticket = gateway.findById(id);
        if (ticket.isEmpty()) {
            throw new EntityNotFoundException("Erro1", "Erro2");
        }
        return TicketVO.create(ticket.get());
    }

    public TicketVO findByName(final String name) {
        final Optional<Ticket> ticket = gateway.findByName(name);
        if (ticket.isEmpty()) {
            throw new EntityNotFoundException("Erro1", "Erro2");
        }
        return TicketVO.create(ticket.get());
    }

    public List<TicketVO> findAll() {
        final List<Ticket> tickets = gateway.findAll();
        return TicketVO.create(tickets);
    }

    public TicketVO create(final TicketVO ticketVO) {
        final Ticket ticket = gateway.save(Ticket.create(ticketVO));
        return TicketVO.create(ticket);
    }

    public TicketVO update(final TicketVO ticketVO) {
        final Optional<Ticket> ticket = gateway.findByName(ticketVO.getName());
        if (ticket.isPresent()) {
            ticketVO.setId(ticket.get().getId());
            return TicketVO.create(ticket.get());
        }
        return TicketVO.create(gateway.save(Ticket.create(ticketVO)));
    }

    public void delete(final String name) {
        final Optional<Ticket> ticket = gateway.findByName(name);
        if (ticket.isPresent()) {
            gateway.delete(ticket.get());
        }
    }

}
