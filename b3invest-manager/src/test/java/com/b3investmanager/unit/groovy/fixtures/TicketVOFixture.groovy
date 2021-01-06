package com.b3investmanager.unit.groovy.fixtures


import com.b3investmanager.model.TicketVO


class TicketVOFixture {

    public static TicketVO createBasicTicketVO() {
        return TicketVO.builder()
                .name("ITSA4")
                .description("Itausa")
                .value(11.36).build();
    }
}
