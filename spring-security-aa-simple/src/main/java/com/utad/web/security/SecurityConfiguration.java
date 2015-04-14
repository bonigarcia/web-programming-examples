package com.utad.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Authentication
		// Path "/" is allowed, every other must be authenticated
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest()
				.authenticated();

		// Login form
		http.formLogin().loginPage("/login").defaultSuccessUrl("/home")
				.failureUrl("/login?error").permitAll();

		// Logout
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		// Authorization
		auth.inMemoryAuthentication().withUser("user").password("p1")
				.roles("USER");
	}

}
