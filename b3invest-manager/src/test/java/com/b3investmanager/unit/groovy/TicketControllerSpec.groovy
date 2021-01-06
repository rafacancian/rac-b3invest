package com.b3investmanager.unit.groovy

import com.b3investmanager.controller.TicketController
import com.b3investmanager.model.TicketVO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

//@SpringBootTest
@WebMvcTest(value = TicketController.class)
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@WebMvcTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration
//@RunWith(SpringRunner.class)
class TicketControllerSpec extends Specification {

    private static final String URL_VALID = "/b3invest/ticket"
    private static final String URL_VALID_VARIABLE = "/b3invest/ticket/PETR4"
    private static final String URL_INVALID = "/b3/b3invest/ticket"

    @Autowired
    MockMvc mvc

    @MockBean
    private TicketController ticketController;

    @Unroll
    def "Validate endpoint to find ticket by name when #scenario"() {
        when: "Call API"
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status);
        then: "The HTTP status should be #statusExcepted"
        where: "when "
        scenario             | status                                      | url
        "the url is valid"   | MockMvcResultMatchers.status().isOk()       | URL_VALID_VARIABLE
        "the url is invalid" | MockMvcResultMatchers.status().isNotFound() | URL_INVALID
    }

    @Unroll
    def "Validate endpoint to find all ticket when #scenario"() {
        when: "Call API"
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status);
        then: "The HTTP status should be #statusExcepted"
        where:
        scenario             | status                                      | url
        "the url is valid"   | MockMvcResultMatchers.status().isOk()       | URL_VALID_VARIABLE
        "the url is invalid" | MockMvcResultMatchers.status().isNotFound() | URL_INVALID
    }

    @Unroll
    def "Validate endpoint to create ticket when #scenario"() {
        given: "A ticketVO"
        TicketVO ticketVO = TicketVO.builder().name("VVAR3").description("Via Varejo").value(18.36).build()
        when: "Call API"
        mvc.perform(post(url)
                .content(asJsonString(ticketVO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status);
        then: "The HTTP status should be correct"
        where:
        scenario             | status                                      | url
        "the url is valid"   | MockMvcResultMatchers.status().isOk()       | URL_VALID
        "the url is invalid" | MockMvcResultMatchers.status().isNotFound() | URL_INVALID
    }

    @Unroll
    def "Validate endpoint to update ticket when #scenario"() {
        given: "A ticketVO"
        TicketVO ticketVO = TicketVO.builder().name("VVAR3").description("Via Varejo").value(18.36).build()
        when: "Call API"
        mvc.perform(put(url)
                .content(asJsonString(ticketVO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status);
        then: "The HTTP status should be correct"
        where:
        scenario             | status                                      | url
        "the url is valid"   | MockMvcResultMatchers.status().isOk()       | URL_VALID
        "the url is invalid" | MockMvcResultMatchers.status().isNotFound() | URL_INVALID
    }

    @Unroll
    def "Validate endpoint to delete ticket when #scenario"() {
        when: "Call API"
        mvc.perform(delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status);
        then: "The HTTP status should be #statusExcepted"
        where:
        scenario             | status                                      | url
        "the url is valid"   | MockMvcResultMatchers.status().isOk()       | URL_VALID_VARIABLE
        "the url is invalid" | MockMvcResultMatchers.status().isNotFound() | URL_INVALID
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
