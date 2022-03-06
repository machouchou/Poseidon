package com.nnk.springboot;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.services.RuleService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class RuleTest {

	private RuleNameRepository ruleNameRepository = Mockito.mock(RuleNameRepository.class);

	private static RuleService ruleService;
	
	@Test
	public void saveRuleTest() {
		ruleService = new RuleService(ruleNameRepository);
		RuleName rule = new RuleName();
		rule.setName("Rule Name");
		rule.setDescription("Description");
		rule.setJson("Json");
		rule.setTemplate("Template");
		rule.setSqlStr("SQL");
		rule.setSqlPart("SQL Part");
		rule.setId(2);
		
		when(ruleNameRepository.save(Mockito.any(RuleName.class))).thenReturn(rule);
		RuleName ruleResult = ruleService.save(rule);
		Assert.assertNotNull(rule.getId());
		assertEquals(rule.getName(), ruleResult.getName());
	}

	@Test
	public void findAllRuleTest() {
		ruleService = new RuleService(ruleNameRepository);
		RuleName rule1 = new RuleName();
		rule1.setName("Rule Name");
		rule1.setDescription("Description");
		rule1.setJson("Json");
		rule1.setTemplate("Template");
		rule1.setSqlStr("SQL");
		rule1.setSqlPart("SQL Part");
		rule1.setId(2);
		
		RuleName rule2 = new RuleName();
		rule2.setName("Rule Name");
		rule2.setDescription("Description");
		rule2.setJson("Json");
		rule2.setTemplate("Template");
		rule2.setSqlStr("SQL");
		rule2.setSqlPart("SQL Part");
		rule2.setId(6);
		
		List<RuleName> listResult = new ArrayList<>();
		listResult.add(rule1);
		listResult.add(rule2);
		
		when(ruleNameRepository.findAll()).thenReturn(listResult);
		List<RuleName> rules = ruleService.findAll();
		assertEquals(listResult.size(), rules.size());
	}
	
	@Test
	public void findById() {
		ruleService = new RuleService(ruleNameRepository);
		
		RuleName rule1 = new RuleName();
		rule1.setName("Rule Name");
		rule1.setDescription("Description");
		rule1.setJson("Json");
		rule1.setTemplate("Template");
		rule1.setSqlStr("SQL");
		rule1.setSqlPart("SQL Part");
		rule1.setId(2);
		
		Optional<RuleName> optResult = Optional.of(rule1);
		
		when(ruleNameRepository.findById(2)).thenReturn(optResult);
		Optional<RuleName> optRule = ruleService.findById(2);
		assertEquals(optResult.get().getId(), optRule.get().getId());
	}
	
	@Test
	public void deleteRuleTest() {
		ruleService = new RuleService(ruleNameRepository);
		RuleName rule = new RuleName();
		rule.setName("Rule Name");
		rule.setDescription("Description");
		rule.setJson("Json");
		rule.setTemplate("Template");
		rule.setSqlStr("SQL");
		rule.setSqlPart("SQL Part");
		rule.setId(3);
		
		Optional<RuleName> ruleResult = ruleNameRepository.findById(3);
		Assert.assertFalse(ruleResult.isPresent());
		doNothing().when(ruleNameRepository).delete(Mockito.any(RuleName.class));
		ruleService.delete(rule);
		verify(ruleNameRepository, times(1)).delete(Mockito.any(RuleName.class));
	}
	
}
