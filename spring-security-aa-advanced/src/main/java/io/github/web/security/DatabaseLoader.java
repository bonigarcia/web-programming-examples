package io.github.web.security;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private UserRepository userRepository;

    public DatabaseLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void initDatabase() {
        // User #1: "user", with password "p1" and role "USER"
        List<GrantedAuthority> userRoles = Arrays
                .asList(new SimpleGrantedAuthority("ROLE_USER"));
        userRepository.save(new User("user", "p1", userRoles));

        // User #2: "root", with password "p2" and roles "USER" and "ADMIN"
        List<GrantedAuthority> adminRoles = Arrays.asList(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN"));
        userRepository.save(new User("root", "p2", adminRoles));
    }

}
