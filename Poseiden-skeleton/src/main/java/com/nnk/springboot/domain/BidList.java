package com.nnk.springboot.domain;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

@Getter @Setter
@Entity
@Table(name = "bidlist")
public class BidList {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer BidListId;
	
	@NonNull private String account;
	
	@NonNull private String type;
	
	private Double bidQuantity;
	private Double askQuantity;
	private Double bid;
	private Double ask;
	private String benchmark;
	private Timestamp bidListDate;
	private String commentary;
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

    // TODO: Map columns in data table BIDLIST with corresponding java fields
}
