package com.b3investmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.b3investmanager.model.TicketVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

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

	public static Ticket create(TicketVO ticketVO) {
		return new ModelMapper().map(ticketVO, Ticket.class);
	}

}