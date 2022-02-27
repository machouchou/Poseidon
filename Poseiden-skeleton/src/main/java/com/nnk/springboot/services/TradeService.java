package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

public class TradeService {
	
	final Logger logger = LogManager.getLogger(TradeService.class);
	
	private final TradeRepository tradeRepository;
	
	public TradeService(TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}
	
	public List<Trade> findAll() {
		logger.debug("Trade List");
		return tradeRepository.findAll();
	}
	
	public Trade save(Trade trade) {
		logger.debug("Trade saved");
		 return tradeRepository.save(trade);
	}
	public Optional<Trade> findById(Integer id) {
		logger.debug("Trade found by Id");
		 return tradeRepository.findById(id);
	}
	
	public void delete(Trade trade) {
		logger.debug("Trade removed");
		tradeRepository.delete(trade);
	}

}
