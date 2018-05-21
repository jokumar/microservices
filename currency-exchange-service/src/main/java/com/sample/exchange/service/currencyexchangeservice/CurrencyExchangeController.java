package com.sample.exchange.service.currencyexchangeservice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	Logger log=LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Resource
	ExchangeDataRepository exchangeDataRepository;
	
	@GetMapping("/exchange/{from}/to/{to}")
	public ExchangeData getExchangeData(@PathVariable String from,
				@PathVariable String to,HttpServletRequest request){
		
		
		ExchangeData exchange=exchangeDataRepository.findByFromCurrencyAndToCurrency(from,to);
		log.info("CurrencyExchangeController response -> {}",exchange);

		exchange.setPort(new Integer(request.getServerPort()).toString());
		return exchange;
	}
}
