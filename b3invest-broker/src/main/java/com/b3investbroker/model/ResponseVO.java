package com.b3investbroker.model;

import lombok.*;
import lombok.experimental.FieldNameConstants;
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
    private LinksVO linksVO;
}
