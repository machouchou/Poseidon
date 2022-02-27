package com.nnk.springboot.controllers;

import javax.validation.Valid;

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

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleService;

@Controller
public class RuleNameController {
	
	private final Logger logger = LoggerFactory.getLogger(RuleNameController.class);
	
   @Autowired
   private RuleService ruleService;

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
    	logger.info("ruleName list");
        model.addAttribute("ruleNames", ruleService.findAll());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
    	logger.info("add ruleName form");
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
    	logger.info("ruleName validate");
    	if (!result.hasErrors()) {
    		ruleService.save(ruleName);
        model.addAttribute("ruleNames", ruleService.findAll());
        return "redirect:/ruleName/list";
    	}
    	return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
    	logger.info("update ruleName form");
        RuleName ruleName = ruleService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
        model.addAttribute("ruleName", ruleName);
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
    	logger.info("update ruleName");
    	if (result.hasErrors()) {
            return "ruleName/update";
        }
    	ruleService.save(ruleName);
        model.addAttribute("ruleNames", ruleService.findAll());
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
    	logger.info("delete ruleName");
    	RuleName ruleName = ruleService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ruleName Id:" + id));
    	ruleService.delete(ruleName);
        model.addAttribute("ruleNames", ruleService.findAll());
        return "redirect:/ruleName/list";
    }
}
