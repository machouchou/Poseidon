package com.nnk.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "rulename")
public class RuleName {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Column(name="description")
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	@Column(name="json")
	@NotBlank(message = "Json is mandatory")
	private String json;
	
	@Column(name="template")
	@NotBlank(message = "Template is mandatory")
	private String template;
	
	@Column(name="sql_str")
	@NotBlank(message = "SqlStr is mandatory")
	private String sqlStr;
	
	@Column(name="sql_part")
	@NotBlank(message = "SqlPart is mandatory")
	String sqlPart;
    
}
