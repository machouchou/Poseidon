package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String moodysRating;
	
	private String sandPRating;
	
	private String fitchRating;
	
	private Integer orderNumber;
	
    // TODO: Map columns in data table RATING with corresponding java fields
}
