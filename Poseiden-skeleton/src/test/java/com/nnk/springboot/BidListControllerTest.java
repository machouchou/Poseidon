package com.nnk.springboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidService;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@WebMvcTest(BidListController.class)
public class BidListControllerTest {
	private BidListRepository bidRepository = Mockito.mock(BidListRepository.class);
	
	BidService bidService;
	@Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

   /* @Before
    public void setup() {
        mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(springSecurity())
          .build();
    }*/

	@Test
	  public void shouldReturnViewWithPrefilledData() throws Exception {
		mvc = MockMvcBuilders
		          .webAppContextSetup(context)
		          .apply(springSecurity())
		          .build();
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

/*	    this.mvc
	      .perform(get("/bidList/list"))
	      .andExpect(status().isOk())
	      .andExpect(view().name("bidList/list"))
	      .andExpect(model().attributeExists("bidLists"));*/
	  }
}

