package com.b3investmanager.model;

import lombok.*;

import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Data
public class LinksVO implements Serializable {
    private String first;
    private String prev;
    private String self;
    private String next;
    private String last;

}
