package com.utad.web.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AdvancedSecurityApp extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedSecurityApp.class, args);
	}
}
