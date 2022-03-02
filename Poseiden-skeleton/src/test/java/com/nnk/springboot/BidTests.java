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

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidService;

public class BidTests {

	private BidListRepository bidRepository = Mockito.mock(BidListRepository.class);
	
	private static BidService bidService;

	@Test
	public void saveBidListTest() {
		bidService = new BidService(bidRepository);
		BidList bid = new BidList();
		bid.setAccount("Account Test");
		bid.setType("Type Test");
		bid.setBidQuantity(10d);
		bid.setId(4);
		
		//BidList bid = new BidList("Account Test", "Type Test", 10d);
		when(bidRepository.save(Mockito.any(BidList.class))).thenReturn(bid);
		// Save
		BidList bidResult = bidService.save(bid);
		Assert.assertNotNull(bid.getId());
		Assert.assertEquals(bid.getBidQuantity(), bidResult.getBidQuantity());
	}

		@Test
		public void findAllBidTest() {
			bidService = new BidService(bidRepository);
			
			BidList bid1 = new BidList();
			bid1.setAccount("Account test");
			bid1.setType("Type Test");
			bid1.setBidQuantity(10d);
			bid1.setId(2);
			
			BidList bid2 = new BidList();
			bid2.setAccount("Account Test");
			bid2.setType("Type Test");
			bid2.setBidQuantity(15d);
			bid2.setId(3);
			
			List<BidList> lResult = new ArrayList<>();
			lResult.add(bid1);
			lResult.add(bid2);
			
			when(bidRepository.findAll()).thenReturn(lResult);
			
			List<BidList> bids = bidService.findAll();
			
			assertNotEquals(Collections.EMPTY_LIST, lResult.size());
			assertEquals(lResult.size(), bids.size());
			assertTrue(lResult.stream().anyMatch(bid ->bid.getBidQuantity().equals(bid1.getBidQuantity())));
		}

	@Test
	public void findByIdTest() {
		bidService = new BidService(bidRepository);
		
		BidList bid = new BidList();
		bid.setAccount("Account test");
		bid.setType("Type Test");
		bid.setBidQuantity(10d);
		bid.setId(2);
		
		Optional<BidList> optResult = Optional.of(bid);
		
		when(bidRepository.findById(2)).thenReturn(optResult);
		
		Optional<BidList> optBid = bidService.findById(2);
		
		assertEquals(optResult.get().getBidQuantity(), optBid.get().getBidQuantity());
		
	}
	@Test
	public void deleteBidTest() {
		bidService = new BidService(bidRepository);
		BidList bid = new BidList();
		bid.setAccount("Account Test");
		bid.setType("Type Test");
		bid.setBidQuantity(10d);
		bid.setId(4);
		
		doNothing().when(bidRepository).delete(Mockito.any(BidList.class));
		bidService.delete(bid);
		verify(bidRepository, times(1)).delete(Mockito.any(BidList.class));
	}
}
