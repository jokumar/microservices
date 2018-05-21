package com.sample.conversion.service.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyConversionController {
	Logger log=LoggerFactory.getLogger(CurrencyConversionController.class);
	@Autowired
	CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/convert/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getcurrencyConverter(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		RestTemplate restTemplate = new RestTemplate();
		HashMap uriMap = new HashMap();
		uriMap.put("from", from);
		uriMap.put("to", to);
		ResponseEntity<CurrencyConversion> response = restTemplate.exchange(
				"http://localhost:8000/exchange/{from}/to/{to}", HttpMethod.GET, null, CurrencyConversion.class,
				uriMap);
		
		
		return new CurrencyConversion(from,to,quantity,response.getBody().getConversionRate(),response.getBody().getPort()) ;
	}
	
	@GetMapping("/currency-conversion-feign/convert/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getcurrencyConverterFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		
		CurrencyConversion response = proxy.getExchangeData(from, to);
		
		log.info("CurrencyConversion response -> {}",response);
		return new CurrencyConversion(from,to,quantity,response.getConversionRate(),response.getPort()) ;
	}
}
