package com.kata.helpDesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kata.helpDesk.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dBService; 
	
	@Bean
	public void instaciaDB() {
		this.dBService.instanciaDB();
	}
}
