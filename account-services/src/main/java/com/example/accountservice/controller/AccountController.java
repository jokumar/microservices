package com.example.accountservice.controller;

import java.net.URI;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.accountservice.entity.User;
import com.example.accountservice.entity.UserBean;
import com.example.accountservice.repositories.UserRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import io.swagger.annotations.ApiModelProperty;

@RestController
@RequestMapping(path="/account")
public class AccountController {

	@Resource
	UserRepository userRepository;
	
	@PostMapping("/user")
	public ResponseEntity<User> register(@Valid @RequestBody UserBean user){
		
		User us=new User();
		us.setEmailId(user.getEmailId());
		us.setFirstName(user.getFirstName());
		us.setLastName(user.getLastName());
		us.setPassword(user.getPassword());
		userRepository.save(us);
		
		//Pass the API URI in the response header
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getEmailId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/login")
	public UserBean login(@RequestBody UserBean user){
		
		return new UserBean();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable String id){
		
		return userRepository.findById(id);
	}
	
	@ApiModelProperty(notes="Dynamic Filtering of the response")
	@GetMapping("/user/filtered/{id}")
	public MappingJacksonValue getFiltereredUser(@PathVariable String id){
		//As part of this API we will fetch only the first name and last name .
		Optional<User> user=userRepository.findById(id);
		
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("firstName","lastName");
		FilterProvider filterProvider=new SimpleFilterProvider().addFilter("sampleFilter", filter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(user);
		mapping.setFilters(filterProvider);
		return mapping;
	}

	
}
