package io.github.web.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HttpsSecurityApp extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(HttpsSecurityApp.class, args);
	}
}
