package io.github.web.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringMvcThymeleafApp extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThymeleafApp.class, args);
    }
}
