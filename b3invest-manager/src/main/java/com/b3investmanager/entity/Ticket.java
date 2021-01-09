package com.b3investmanager.entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket")
@ToString
@EqualsAndHashCode
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
public class Ticket implements Serializable {

    private static final long serialVersionUID = -3661292867055495781L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 5)
    private String name;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "value", nullable = false)
    private Double value;

}