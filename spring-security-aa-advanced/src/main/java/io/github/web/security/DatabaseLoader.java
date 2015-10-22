package io.github.web.security;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void initDatabase() {
		// User #1: "user", with password "p1" and role "USER"
		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority("ROLE_USER") };
		userRepository.save(new User("user", "p1", Arrays.asList(userRoles)));

		// User #2: "root", with password "p2" and roles "USER" and "ADMIN"
		GrantedAuthority[] adminRoles = {
				new SimpleGrantedAuthority("ROLE_USER"),
				new SimpleGrantedAuthority("ROLE_ADMIN") };
		userRepository.save(new User("root", "p2", Arrays.asList(adminRoles)));
	}

}
