package io.github.web.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userRepository.findByUser(username);

        if (user == null) {
            throw new BadCredentialsException("User not found");
        }
        if (!new BCryptPasswordEncoder().matches(password,
                user.getPasswordHash())) {
            throw new BadCredentialsException("Wrong password");
        }

        List<GrantedAuthority> roles = user.getRoles();

        return new UsernamePasswordAuthenticationToken(username, password,
                roles);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
