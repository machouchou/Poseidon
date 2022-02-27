package com.nnk.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;

@Getter @Setter
@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message="Curve Id must not be null")
	@Column(name="curve_id")
	private Integer curveId;
	
	//@Column(name="as_of_date")
	private Timestamp asOfDate;
	
	@Column(name="term")
	private Double term;
	
	@Column(name="value")
	private Double value;
	
	//@Column(name="creation_date")
	private Timestamp creationDate;
}
