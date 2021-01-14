package com.b3investmanager.unit.junit.service;

import com.b3investmanager.exception.EntityNotFoundException;
import com.b3investmanager.exception.GatewayException;
import com.b3investmanager.external.TicketGatewayImpl;
import com.b3investmanager.service.TicketService;
import com.b3investmanager.unit.groovy.fixtures.TicketFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class TicketServiceTest {

    final TicketGatewayImpl gateway = mock(TicketGatewayImpl.class);
    final TicketService service = new TicketService(gateway);
    private static final String TICKET_NAME = "ITSA4";

    @Test
    void shouldFindTicketWithSuccess() {
        when(gateway.findByName(TICKET_NAME)).thenReturn(TicketFixture.createOptionalBasicTicket());
        service.findByName(TICKET_NAME);
        verify(gateway, times(1)).findByName(TICKET_NAME);
    }

    @Test
    void shouldReturnGatewayExceptionWhenFindTicketWithSystemError() throws GatewayException {
        when(gateway.findByName(TICKET_NAME)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> service.findByName(TICKET_NAME));
    }

}
