package com.sample.limitservice;

import javax.annotation.Resource;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

	@Resource
	private Environment env;
	
	@GetMapping("/limits")
	public LimitConfiguration getConfiguration(){
		
		return new LimitConfiguration(env.getProperty("prop.min"),env.getProperty("prop.max"));
	}
}
