package com.b3investmanager.external;

import com.b3investmanager.entity.Ticket;
import com.b3investmanager.exception.GatewayException;
import com.b3investmanager.external.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class TicketGatewayImpl implements TicketGateway {

    public static final String MSG_ERROR_FIND_BY_ID = "Internal error when try to find ticket by ID on database";
    public static final String MSG_ERROR_FIND_BY_NAME = "Internal error when try to find ticket by name on database";
    public static final String MSG_ERROR_FIND_ALL = "Internal error when try to find all ticket on database";
    public static final String MSG_ERROR_SAVE = "Internal error when try to save ticket on database";
    public static final String MSG_ERROR_DELETE = "Internal error when try to delete ticket database";

    private final TicketRepository repository;

    @Override
    public Optional<Ticket> findById(final Long id) {
        try {
            log.debug("TicketGatewayImpl find ticket by id");
            return repository.findById(id);
        } catch (final Exception e) {
            log.error(MSG_ERROR_FIND_BY_ID);
            throw new GatewayException(MSG_ERROR_FIND_BY_ID, e);
        }
    }

    @Override
    @Cacheable(cacheNames = "Tickets", key = "(#root.method.name)")
    public Optional<Ticket> findByName(final String name) {
        try {
            log.debug("TicketGatewayImpl find ticket by name");
            return repository.findByName(name);
        } catch (final Exception e) {
            log.error(MSG_ERROR_FIND_BY_NAME);
            throw new GatewayException(MSG_ERROR_FIND_BY_NAME, e);
        }
    }

    @Override
    @Cacheable(cacheNames = "Tickets", key = "(#root.method.name)")
    public List<Ticket> findAll() {
        try {
            log.debug("TicketGatewayImpl find all ticket");
            return repository.findAll();
        } catch (final Exception e) {
            log.error(MSG_ERROR_FIND_ALL);
            throw new GatewayException(MSG_ERROR_FIND_ALL, e);
        }
    }

    @Override
    @CachePut(value = "Tickets", key = "#ticket.id")
    public Ticket save(final Ticket ticket) {
        try {
            log.debug("TicketGatewayImpl save ticket");
            return repository.save(ticket);
        } catch (final Exception e) {
            log.error(MSG_ERROR_SAVE);
            throw new GatewayException(MSG_ERROR_SAVE, e);
        }
    }

    @Override
    @CacheEvict(value = "Tickets", key = "#ticket.id")
    public void delete(final Ticket ticket) {
        try {
            log.debug("TicketGatewayImpl delete ticket");
            repository.delete(ticket);
        } catch (final Exception e) {
            log.error(MSG_ERROR_DELETE);
            throw new GatewayException(MSG_ERROR_DELETE, e);
        }
    }

}
