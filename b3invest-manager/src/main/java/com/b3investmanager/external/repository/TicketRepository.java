package com.b3investmanager.external.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3investmanager.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	Optional<Ticket> findByName(String name);

}
