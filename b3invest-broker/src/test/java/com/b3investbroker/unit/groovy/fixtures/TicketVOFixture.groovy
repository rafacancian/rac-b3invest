package com.b3investbroker.unit.groovy.fixtures

import com.b3investbroker.model.TicketVO

class TicketVOFixture {

    public static com.b3investbroker.model.TicketVO createBasicTicketVO() {
        return TicketVO.builder()
                .name("ITSA4")
                .description("Itausa")
                .value(11.36).build();
    }
}
