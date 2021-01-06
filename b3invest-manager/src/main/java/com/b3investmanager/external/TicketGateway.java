package com.b3investmanager.external;

import com.b3investmanager.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketGateway {

    Optional<Ticket> findById(Long id);

    Optional<Ticket> findByName(String name);

    List<Ticket> findAll();

    Ticket save(Ticket create);

    void delete(Ticket create);

}
