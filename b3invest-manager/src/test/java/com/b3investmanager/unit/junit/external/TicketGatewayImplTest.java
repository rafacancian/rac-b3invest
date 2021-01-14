package com.b3investmanager.unit.junit.external;

import com.b3investmanager.exception.GatewayException;
import com.b3investmanager.external.TicketGatewayImpl;
import com.b3investmanager.external.repository.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TicketGatewayImplTest {

    @Test
    void shouldFindTicketWithSuccess() {
        final TicketRepository repository = mock(TicketRepository.class);
        final TicketGatewayImpl gateway = new TicketGatewayImpl(repository);
        gateway.findByName("B3SA3");
        verify(repository, times(1)).findByName("B3SA3");
    }

    @Test
    void shouldReturnGatewayExceptionWhenFindTicketWithSystemError() throws GatewayException {
        final TicketRepository repository = mock(TicketRepository.class);
        final TicketGatewayImpl gateway = new TicketGatewayImpl(repository);
        when(repository.findByName("B3SA3")).thenThrow(new GatewayException("Internal server error"));
        Assertions.assertThrows(GatewayException.class, () -> gateway.findByName("B3SA3"));
    }


}
