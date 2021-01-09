package com.b3investmanager.external;

import com.b3investmanager.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TicketGateway {

    Optional<Ticket> findById(Long id);

    Optional<Ticket> findByName(String name);

    Page<Ticket> findAll(Pageable pageable);

    Ticket save(Ticket create);

    void delete(Ticket create);

}
