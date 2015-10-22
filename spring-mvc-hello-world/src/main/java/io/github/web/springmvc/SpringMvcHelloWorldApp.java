package io.github.web.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringMvcHelloWorldApp extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcHelloWorldApp.class, args);
	}
}
