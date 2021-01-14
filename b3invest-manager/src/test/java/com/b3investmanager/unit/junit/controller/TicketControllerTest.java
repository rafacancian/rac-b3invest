package com.b3investmanager.unit.junit.controller;

import com.b3investmanager.controller.TicketController;
import com.b3investmanager.unit.groovy.fixtures.TicketVOFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(value = TicketController.class)
public class TicketControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TicketController ticketController;

    ResponseEntity response;

    @BeforeEach
    public void setup() {
        response = new ResponseEntity<>(TicketVOFixture.createBasicTicketVO(), HttpStatus.OK);
    }

    @Test
    void shouldFindTicketByNameWhenTheURLIsValid() throws Exception {
        when(ticketController.findByName("ITSA4")).thenReturn(response);
        this.mvc.perform(get("/ticket/ITSA4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(containsString("ITSA4")));
        verify(ticketController, times(1)).findByName(anyString());
    }

    @Test
    void shouldNotFindTicketByNameWhenTheURLIsInvalid() throws Exception {
        this.mvc.perform(get("/b3/ticket/ITSA4"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        verify(ticketController, times(0)).findByName(anyString());
    }


}
