package com.b3investmanager.service;

import com.b3investmanager.adapter.ResponseVOAdapter;
import com.b3investmanager.adapter.TicketAdapter;
import com.b3investmanager.adapter.TicketVOAdapter;
import com.b3investmanager.entity.Ticket;
import com.b3investmanager.exception.EntityNotFoundException;
import com.b3investmanager.external.TicketGateway;
import com.b3investmanager.model.ResponseVO;
import com.b3investmanager.model.TicketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Links;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketGateway gateway;

    @Autowired
    private PagedResourcesAssembler<Ticket> pagedResourcesAssembler;

    public TicketVO findById(final Long id) {
        final Optional<Ticket> ticket = gateway.findById(id);
        if (ticket.isEmpty()) {
            throw new EntityNotFoundException("Erro1", "Erro2");
        }
        return TicketVOAdapter.create(ticket.get());
    }

    public TicketVO findByName(final String name) {
        final Optional<Ticket> ticket = gateway.findByName(name);
        if (ticket.isEmpty()) {
            throw new EntityNotFoundException("Erro1", "Erro2");
        }
        return TicketVOAdapter.create(ticket.get());
    }

    public ResponseVO findAll(int page, int size) {
        final Pageable pageable = PageRequest.of(page, size);
        final Page<Ticket> pageTickets = gateway.findAll(pageable);
        final Links links = pagedResourcesAssembler.toModel(pageTickets).getLinks();
        List<TicketVO> ticketVOs = TicketVOAdapter.create(pageTickets.getContent());
        return ResponseVOAdapter.create(ticketVOs, links);
    }

    public TicketVO create(final TicketVO ticketVO) {
        final Ticket ticket = gateway.save(TicketAdapter.create(ticketVO));
        return TicketVOAdapter.create(ticket);
    }

    public TicketVO update(final TicketVO ticketVO) {
        final Optional<Ticket> ticket = gateway.findByName(ticketVO.getName());
        if (ticket.isPresent()) {
            ticketVO.setId(ticket.get().getId());
            return TicketVOAdapter.create(ticket.get());
        }
        return TicketVOAdapter.create(gateway.save(TicketAdapter.create(ticketVO)));
    }

    public void delete(final String name) {
        final Optional<Ticket> ticket = gateway.findByName(name);
        ticket.ifPresent(gateway::delete);
    }

}
