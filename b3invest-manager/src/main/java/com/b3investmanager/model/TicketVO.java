package com.b3investmanager.model;

import com.b3investmanager.entity.Ticket;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"id", "name", "description", "value"})
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
public class TicketVO extends RepresentationModel<TicketVO> implements Serializable {

    private static final long serialVersionUID = 1254191434652058949L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("value")
    private Double value;

    public static TicketVO create(final Ticket ticket) {
        if (!ObjectUtils.isEmpty(ticket)) {
            return new ModelMapper().map(ticket, TicketVO.class);
        }
        return TicketVO.builder().build();
    }

    public static List<TicketVO> create(final List<Ticket> tickets) {
        final List<TicketVO> ticketVOs = new ArrayList<>();
        if (!ObjectUtils.isEmpty(tickets)) {
            tickets.stream().forEach(t -> {
                ticketVOs.add(new ModelMapper().map(t, TicketVO.class));
            });
        }
        return ticketVOs;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
    }

}
