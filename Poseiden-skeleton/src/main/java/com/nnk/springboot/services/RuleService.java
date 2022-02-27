package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

@Service
public class RuleService {
	

	final Logger logger = LogManager.getLogger(RuleService.class);

	private final RuleNameRepository ruleRepository;
	
	public RuleService(RuleNameRepository ruleRepository) {
		this.ruleRepository = ruleRepository;
	}
	
	public List<RuleName> findAll() {
		logger.debug("Rule List");
		return ruleRepository.findAll();
	}
	
	public RuleName save(RuleName rule) {
		logger.debug("Rule saved");
		 return ruleRepository.save(rule);
	}
	public Optional<RuleName> findById(Integer id) {
		logger.debug("Rule found by Id");
		 return ruleRepository.findById(id);
	}
	
	public void delete(RuleName rule) {
		logger.debug("Rule removed");
		 ruleRepository.delete(rule);
	}

}
