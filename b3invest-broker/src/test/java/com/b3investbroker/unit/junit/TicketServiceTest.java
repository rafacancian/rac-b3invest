package com.b3investbroker.unit.junit;

import com.b3investbroker.exception.BaseException;
import com.b3investbroker.exception.GatewayException;
import com.b3investbroker.external.TicketFeignClient;
import com.b3investbroker.external.TicketGateway;
import com.b3investbroker.external.TicketGatewayImpl;
import com.b3investbroker.model.TicketVO;
import com.b3investbroker.service.TicketService;
import com.b3investbroker.unit.groovy.fixtures.TicketVOFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class TicketServiceTest {

    final TicketGateway ticketGateway = mock(TicketGatewayImpl.class);
    final TicketService ticketService = new TicketService(ticketGateway);

    @Test
    void shouldFindTicketWithSuccess() {
        ticketService.findByName("B3SA3");
        verify(ticketGateway, times(1)).findByName("B3SA3");
    }

    @Test
    void shouldReturnGatewayExceptionWhenFindTicketWithSystemError() throws GatewayException {
        when(ticketService.findByName("B3SA3")).thenThrow(new BaseException());
        Assertions.assertThrows(BaseException.class, () -> ticketService.findByName("B3SA3"));
    }

}
