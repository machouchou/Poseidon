package com.nnk.springboot.controllers;

import com.nnk.springboot.config.GithubUser;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class BidListController {
	
	private final Logger logger = LoggerFactory.getLogger(BidListController.class);
	
    @Autowired
    private BidService bidService;
    
    @Autowired
	private GithubUser githubUser;

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
    	logger.info("bidList list");
    	System.out.println(githubUser.getUsername());
    	model.addAttribute("username", githubUser.getUsername());
        model.addAttribute("bidLists", bidService.findAll());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
    	logger.info("add bidList form");
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
    	logger.info("bidList validate");
    	if (!result.hasErrors()) {
    		bidService.save(bid);
    		model.addAttribute("bids", bidService.findAll());
    		return "redirect:/bidList/list";
    	}
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	logger.info("update bidList form");
    	BidList bidList = bidService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
    	model.addAttribute("bidList", bidList);
    	return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
    	logger.info("bidList update");
    	if (result.hasErrors()) {
            return "bidList/update";
        }
    	bidService.save(bidList);
		model.addAttribute("bidLists", bidService.findAll());
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
    	logger.info("bidList delete");
    	BidList bidList = bidService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid bidList Id:" + id));
    	bidService.delete(bidList);
    	model.addAttribute("bidLists", bidService.findAll());
        return "redirect:/bidList/list";
    }
}
