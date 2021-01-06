package com.b3investmanager.unit.groovy.fixtures


import com.b3investmanager.entity.Ticket

class TicketFixture {

	public static Ticket createBasicTicket() {
		return Ticket.builder()
				.name("ITSA4")
				.description("Itausa")
				.value(11.36).build();
	}
}
