package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@NotNull(message="Rating Id must not be null")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="moodys_rating")
	private String moodysRating;
	
	@Column(name="sandprating")
	private String sandPRating;
	
	@Column(name="fitch_rating")
	private String fitchRating;
	
	@Column(name="order_number")
	private Integer orderNumber;
	
}
