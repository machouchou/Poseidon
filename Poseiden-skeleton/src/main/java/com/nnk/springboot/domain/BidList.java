package com.nnk.springboot.domain;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;

@Getter @Setter
@Entity
@Table(name = "bidlist")
public class BidList {
	
	@Id
	//@NotNull(message="Bid List Id must not be null")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	//@Column(name="id")
	private Integer id;
	
	@NotNull(message="Account is mandatory")
	@Column(name="account")
	@NonNull private String account;
	
	@NotNull(message="Type is mandatory")
	@Column(name="type")
	@NonNull private String type;
	
	@Column(name="bid_quantity")
	private Double bidQuantity;
	
	//@Column(name="askQuantity")
	private Double askQuantity;
	
	//@Column(name="bid")
	private Double bid;
	
	//@Column(name="ask")
	private Double ask;
	
	//@Column(name="benchmark")
	private String benchmark;
	
	//@Column(name="bidListDate")
	private Timestamp bidListDate;
	
	//@Column(name="commentary")
	private String commentary;
	
	//@Column(name="security")
	private String security;
	
	//@Column(name="status")
	private String status;
	
	//@Column(name="trader")
	private String trader;
	
	//@Column(name="book")
	private String book;
	
	//@Column(name="creationName")
	private String creationName;
	
	//@Column(name="creationDate")
	private Timestamp creationDate;
	
	//@Column(name="revisionName")
	private String revisionName;
	
	//@Column(name="revisionDate")
	private Timestamp revisionDate;
	
	//@Column(name="dealName")
	private String dealName;
	
	//@Column(name="dealType")
	private String dealType;
	
	//@Column(name="sourceListId")
	private String sourceListId;
	
	//@Column(name="side")
	private String side;

}
