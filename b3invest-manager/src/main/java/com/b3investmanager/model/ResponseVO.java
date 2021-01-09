package com.b3investmanager.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class ResponseVO extends RepresentationModel<ResponseVO> implements Serializable {
    private List<TicketVO> tickets;
    private Links links;
}
