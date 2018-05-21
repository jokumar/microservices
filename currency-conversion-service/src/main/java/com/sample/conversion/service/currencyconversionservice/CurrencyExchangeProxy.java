package com.sample.conversion.service.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-service",url="http://localhost:8000")
//@FeignClient(name="currency-exchange-service") //When Currency conversion hits to exchange service directly by the name with feign
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange-service/exchange/{from}/to/{to}")
	public CurrencyConversion getExchangeData(@PathVariable("from") String from,
				@PathVariable("to") String to);
	
}
