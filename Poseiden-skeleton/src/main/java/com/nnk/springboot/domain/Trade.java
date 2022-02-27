package com.nnk.springboot.domain;

import java.sql.Timestamp;

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
@Table(name = "trade")
public class Trade {
	
	@Id
	//@NotNull(message="Trade Id must not be null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="account")
	@NotBlank(message = "Account is mandatory")
	private String account;
	
	@Column(name="type")
	@NotBlank(message = "Type is mandatory")
	private String type;
	
	@Column(name="buy_quantity")
	private Double buyQuantity;
	
	private Double sellQuantity;
	
	private Double buyPrice;
	
	private Double sellPrice;
	
	private String benchmark;
	
	private Timestamp tradeDate;
	
	private String security;
	
	private String status;
	
	private String trader;
	
	private String book;
	
	private String creationName;
	
	private Timestamp creationDate;
	
	private String revisionName;
	
	private Timestamp revisionDate;
	
	private String dealName;
	
	private String dealType;
	
	private String sourceListId;
	
	private String side;

}
