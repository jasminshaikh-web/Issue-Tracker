package com.IssueTracker.IssueTracker.dozer;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {
	@Bean
	public DozerBeanMapper dozerBeanMapper() {
		DozerBeanMapper beanMapper=new DozerBeanMapper();
		beanMapper.addMapping(new IssueDozer());
		beanMapper.addMapping(new ProjectDozer());
		beanMapper.addMapping(new TeamDozer());
		return beanMapper;
	}
	
	
}
