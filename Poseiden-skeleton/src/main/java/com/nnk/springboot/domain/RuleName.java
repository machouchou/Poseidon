package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@Entity
@Table(name = "rulename")
public class RuleName {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	@NotBlank(message = "Json is mandatory")
	private String json;
	
	@NotBlank(message = "Template is mandatory")
	private String template;
	
	@NotBlank(message = "SqlStr is mandatory")
	private String sqlStr;
	
	@NotBlank(message = "SqlPart is mandatory")
	String sqlPart;
    // TODO: Map columns in data table RULENAME with corresponding java fields
}
