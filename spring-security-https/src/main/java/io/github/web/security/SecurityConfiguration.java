package io.github.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Paths that can be visited without authentication
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();

        // Paths that cannot be visited without authentication
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/login?error");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/login?logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Authorization
        auth.inMemoryAuthentication().withUser("user").password("p1")
                .roles("USER");
    }

}
