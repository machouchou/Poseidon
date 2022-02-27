package com.nnk.springboot.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.services.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
 
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userService.findByUsername(name);
        boolean result = passwordEncoder.matches(password, user.getPassword());

        if (result) {
 
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              name, password, new ArrayList<>());
        } else {
        	throw new BadCredentialsException("Wrong Username or password.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

