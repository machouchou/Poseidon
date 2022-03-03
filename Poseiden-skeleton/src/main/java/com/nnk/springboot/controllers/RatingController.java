package com.nnk.springboot.controllers;

import com.nnk.springboot.config.GithubUser;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.services.RatingService;

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
public class RatingController {
	
	private final Logger logger = LoggerFactory.getLogger(RatingController.class);

	@Autowired
	private RatingService ratingService;

	@Autowired
	private GithubUser githubUser;
	
    @RequestMapping("/rating/list")
    public String home(Model model)
    {
    	logger.info("rating list");
    	/*String currentPrincipalName;
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
			OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
			OAuth2User oAuth2User = oauthToken.getPrincipal();
			Map<String,Object> attributes =  oAuth2User.getAttributes();
			currentPrincipalName = (String) attributes.get("login");
		} else {
			currentPrincipalName = authentication.getName();
		}*/

    	System.out.println(githubUser.getUsername());
    	model.addAttribute("username", githubUser.getUsername());
    	model.addAttribute("ratings", ratingService.findAll());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
    	logger.info("add rating form");
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
    	logger.info("rating validate");
    	if (!result.hasErrors()) {
    		ratingService.save(rating);
    		model.addAttribute("ratings", ratingService.findAll());
    		return "redirect:/rating/list";
    	}
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	logger.info("update rating form");
    	Rating rating = ratingService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
    	model.addAttribute("rating", rating);
    	return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
    	logger.info("update rating");
    	if (result.hasErrors()) {
            return "rating/update";
        }
    	ratingService.save(rating);
        model.addAttribute("ratings", ratingService.findAll());
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
    	logger.info("delete rating");
    	Rating rating = ratingService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rating Id:" + id));
    	ratingService.delete(rating);
    	model.addAttribute("ratings", ratingService.findAll());
        return "redirect:/rating/list";
    }
}
