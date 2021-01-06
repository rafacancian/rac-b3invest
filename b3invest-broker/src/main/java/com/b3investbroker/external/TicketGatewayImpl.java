package com.b3investbroker.external;

import com.b3investbroker.exception.GatewayException;
import com.b3investbroker.model.TicketVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
//@RequiredArgsConstructor
@AllArgsConstructor
public class TicketGatewayImpl implements TicketGateway {

    public static final String MSG_ERROR_FIND_BY_NAME = "Internal error when try to find ticket by name on database";
    public static final String MSG_ERROR_FIND_ALL = "Internal error when try to find all ticket on database";

    @Autowired
    private final TicketFeignClient ticketFeignClient;

    @Override
    public TicketVO findByName(final String name) {
        try {
            log.debug("TicketGatewayImpl find ticket by name");
            final ResponseEntity<?> response = ticketFeignClient.findByName(name);
            return TicketVO.create(response);
        } catch (final Exception e) {
            log.error(MSG_ERROR_FIND_BY_NAME);
            throw new GatewayException(MSG_ERROR_FIND_BY_NAME, e);
        }
    }

    @Override
    public List<TicketVO> findAll() {
        try {
            log.debug("TicketGatewayImpl find all ticket");
            final ResponseEntity<?> response = ticketFeignClient.findAll();
            return (List<TicketVO>) response.getBody();
        } catch (final Exception e) {
            log.error(MSG_ERROR_FIND_ALL);
            throw new GatewayException(MSG_ERROR_FIND_ALL, e);
        }
    }


}
