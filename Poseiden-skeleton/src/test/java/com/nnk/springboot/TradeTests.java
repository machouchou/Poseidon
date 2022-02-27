package com.nnk.springboot;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.RatingService;
import com.nnk.springboot.services.TradeService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

		/* Find
		List<Trade> listResult = tradeRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);*/

	@Test
	public void deleteTradeTest() {
		tradeService = new TradeService(tradeRepository);
		Trade trade = new Trade();
		trade.setAccount("Trade Account");
		trade.setType("Type");
		trade.setId(6);
	Optional<Trade> tradeList = tradeRepository.findById(6);
	Assert.assertFalse(tradeList.isPresent());
	doNothing().when(tradeRepository).delete(Mockito.any(Trade.class));
	tradeService.delete(trade);
	verify(tradeRepository, times(1)).delete(Mockito.any(Trade.class));
}
}
