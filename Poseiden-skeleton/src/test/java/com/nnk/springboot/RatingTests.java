package com.nnk.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.services.RatingService;

public class RatingTests {

	private RatingRepository ratingRepository =Mockito.mock(RatingRepository.class);

	private static RatingService ratingService;

	@Test
	public void saveRatingTest() {
		ratingService = new RatingService(ratingRepository);
		Rating rating = new Rating();
		rating.setMoodysRating("Moodys Rating");
		rating.setSandPRating("Sand PRating");
		rating.setFitchRating("Fitch Rating");
		rating.setOrderNumber(10);
		rating.setId(3);

		when(ratingRepository.save(Mockito.any(Rating.class))).thenReturn(rating);

		Rating ratingResult = ratingService.save(rating);
		Assert.assertNotNull(ratingResult.getId());
		assertEquals(rating.getId(), ratingResult.getId());
		//assertEquals(10, rating.getOrderNumber());
	}
	
	@Test
	public void findAll() {
		ratingService = new RatingService(ratingRepository);
		
		Rating rating1 =new Rating();
		rating1.setMoodysRating("Moodys Rating");
		rating1.setSandPRating("Sand PRating");
		rating1.setFitchRating("Fitch Rating");
		rating1.setOrderNumber(8);
		rating1.setId(4);
		
		Rating rating2 =new Rating();
		rating2.setMoodysRating("Moodys Rating");
		rating2.setSandPRating("Sand PRating");
		rating2.setFitchRating("Fitch Rating");
		rating2.setOrderNumber(12);
		rating2.setId(5);
		
		List<Rating> lResult = new ArrayList<>();
		lResult.add(rating1);
		lResult.add(rating2);
		
		when(ratingRepository.findAll()).thenReturn(lResult);
		
		List<Rating> ratings = ratingService.findAll();
		
		assertNotEquals(Collections.EMPTY_LIST, lResult.size());
		assertEquals(lResult.size(), ratings.size());
		assertTrue(lResult.stream().anyMatch(rating -> rating.getId().equals(rating1.getId())));
	}
	
	/*public void findById() {
		ratingService = new RatingService(ratingRepository);
		
		Rating rating =new Rating();
		rating.setMoodysRating("Moodys Rating");
		rating.setSandPRating("Sand PRating");
		rating.setFitchRating("Fitch Rating");
		rating.setOrderNumber(8);
		rating.setId(4);
		
		Optional<Rating> optResultat = Optional.of(rating);
		when(ratingRepository.findById(4)).thenReturn(optResultat);
		
		Optional<Rating> optRating = ratingService.findById(4);
		
		assertEquals(optResultat.get().getId(), optRating.get().getId());
	}*/
		@Test
		public void deleteRatingTest() {
			ratingService = new RatingService(ratingRepository);
			Rating rating = new Rating();
			rating.setMoodysRating("Moodys Rating");
			rating.setSandPRating("Sand PRating");
			rating.setFitchRating("Fitch Rating");
			rating.setOrderNumber(6);
			rating.setId(3);
		Optional<Rating> ratingList = ratingRepository.findById(3);
		Assert.assertFalse(ratingList.isPresent());
		doNothing().when(ratingRepository).delete(Mockito.any(Rating.class));
		ratingService.delete(rating);
		verify(ratingRepository, times(1)).delete(Mockito.any(Rating.class));
	}
}
