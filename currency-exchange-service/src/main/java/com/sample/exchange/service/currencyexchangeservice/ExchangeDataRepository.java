package com.sample.exchange.service.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeDataRepository extends JpaRepository<ExchangeData,Long>{

	//Using Query method of JPA
	public ExchangeData findByFromCurrencyAndToCurrency(String from, String to);
		
}
