package com.nnk.springboot;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TradeTests {

	private TradeRepository tradeRepository =Mockito.mock(TradeRepository.class);;

	private static TradeService tradeService;
	
	@Test
	public void saveTradeTest() {
		tradeService = new TradeService(tradeRepository);
		Trade trade = new Trade();
		trade.setAccount("Trade Account");
		trade.setType("Type");
		trade.setId(6);
		
		//Trade trade = new Trade("Trade Account", "Type");
		
		when(tradeRepository.save(Mockito.any(Trade.class))).thenReturn(trade);
		
		Trade tradeResult = tradeService.save(trade);
		trade = tradeRepository.save(trade);
		Assert.assertNotNull(tradeResult.getId());
		assertEquals(trade.getId(), tradeResult.getId());
		//assertEquals(trade.getAccount(), tradeResult.getAccount());
	}

	@Test
	public void findAllTrade() {
		
		Trade trade1 = new Trade();
		trade1.setAccount("Trade Account");
		trade1.setType("Type");
		trade1.setId(7);
		
		Trade trade2 = new Trade();
		trade2.setAccount("Trade Account");
		trade2.setType("Type");
		trade2.setId(8);
		
		List<Trade> lTrade = new ArrayList<>();
		lTrade.add(trade1);
		lTrade.add(trade2);
		
		when(tradeRepository.findAll()).thenReturn(lTrade);
		
		tradeService = new TradeService(tradeRepository);
		List<Trade> trades = tradeService.findAll();
		
		assertNotNull(trades.size());
		assertEquals(2, trades.size());
		assertTrue(trades.contains(trade1));
	}
	
	@Test
	public void findById() {
		tradeService = new TradeService(tradeRepository);
		Trade trade = new Trade();
		trade.setAccount("Trade Account");
		trade.setType("Type");
		trade.setId(4);
		
		Optional<Trade> optResult = Optional.of(trade);
		
		when(tradeRepository.findById(4)).thenReturn(optResult);
		
		Optional<Trade> optCurve = tradeService.findById(4);
		
		assertNotNull(trade.getId());
		assertEquals(optResult.get().getAccount(), optCurve.get().getAccount());
	}
	
	@Test
	public void deleteTradeTest() {
		tradeService = new TradeService(tradeRepository);
		Trade trade = new Trade();
		trade.setAccount("Trade Account");
		trade.setType("Type");
		trade.setId(6);
		Optional<Trade> tradeResult = tradeRepository.findById(6);
		Assert.assertFalse(tradeResult.isPresent());
		doNothing().when(tradeRepository).delete(Mockito.any(Trade.class));
		tradeService.delete(trade);
		verify(tradeRepository, times(1)).delete(Mockito.any(Trade.class));
}
}
