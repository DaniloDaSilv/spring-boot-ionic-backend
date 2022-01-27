package com.danilods.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.danilods.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService sbService;
	
	
	@Bean
	public boolean instantaiteDatabase() throws ParseException {
		sbService.instantiateTestDatabase();
		return true;
	}
}
