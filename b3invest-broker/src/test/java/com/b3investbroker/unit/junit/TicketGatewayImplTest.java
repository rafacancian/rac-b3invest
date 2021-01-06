package com.b3investbroker.unit.junit;

import com.b3investbroker.exception.GatewayException;
import com.b3investbroker.external.TicketFeignClient;
import com.b3investbroker.external.TicketGatewayImpl;
import com.b3investbroker.unit.groovy.fixtures.TicketVOFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class TicketGatewayImplTest {

    final TicketFeignClient ticketFeignClient = mock(TicketFeignClient.class);
    final TicketGatewayImpl gateway = new TicketGatewayImpl(ticketFeignClient);


    @Test
    void shouldFindTicketWithSuccess() {
        final ResponseEntity responseEntity = new ResponseEntity(TicketVOFixture.createBasicTicketVO(), HttpStatus.OK);
        when(ticketFeignClient.findByName("B3SA3")).thenReturn(responseEntity);
        gateway.findByName("B3SA3");
        verify(ticketFeignClient, times(1)).findByName("B3SA3");
    }

    @Test
    void shouldReturnGatewayExceptionWhenFindTicketWithSystemError() throws GatewayException {
        when(ticketFeignClient.findByName("B3SA3")).thenThrow(new GatewayException());
        Assertions.assertThrows(GatewayException.class, () -> gateway.findByName("B3SA3"));
    }


}
