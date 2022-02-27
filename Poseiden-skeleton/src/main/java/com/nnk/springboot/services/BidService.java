package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

@Service
public class BidService {
	
	final Logger logger = LogManager.getLogger(BidService.class);

	private final BidListRepository bidRepository;
	
	public BidService(BidListRepository bidRepository) {
		this.bidRepository = bidRepository;
	}
	
	public List<BidList> findAll() {
		logger.debug("Bid List");
		return bidRepository.findAll();
	}
	
	public BidList save(BidList bid) {
		logger.debug("Bid saved");
		 return bidRepository.save(bid);
	}
	public Optional<BidList> findById(Integer id) {
		logger.debug("Bid found by Id");
		 return Optional.ofNullable(bidRepository.findById(id).orElseThrow(() -> 
		 new IllegalArgumentException("Invalid bid Id:" + id)));
	}
	
	public void delete(BidList bid) {
		logger.debug("Bid removed");
		 bidRepository.delete(bid);
	}

}
