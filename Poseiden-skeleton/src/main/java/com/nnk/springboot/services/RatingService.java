package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

@Service
public class RatingService {
	
	final Logger logger = LogManager.getLogger(RatingService.class);

	private final RatingRepository ratingRepository;
	
	public RatingService(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}
	
	public List<Rating> findAll() {
		logger.debug("Rating List");
		return ratingRepository.findAll();
	}
	
	public Rating save(Rating rating) {
		logger.debug("Rating saved");
		 return ratingRepository.save(rating);
	}
	public Optional<Rating> findById(Integer id) {
		logger.debug("Rating found By Id");
		 return ratingRepository.findById(id);
	}
	
	public void delete(Rating rating) {
		logger.debug("Rating removed");
		 ratingRepository.delete(rating);
	}

}
