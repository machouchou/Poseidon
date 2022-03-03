package com.nnk.springboot.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SocialConfig {

	@Bean
	@RequestScope
	public GithubUser github() {
		String currentPrincipalName;
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
			OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
			OAuth2User oAuth2User = oauthToken.getPrincipal();
			Map<String,Object> attributes =  oAuth2User.getAttributes();
			currentPrincipalName = (String) attributes.get("login");
		} else {
			currentPrincipalName = authentication.getName();
		}

			GithubUser githubUser = new GithubUser();
			githubUser.setUsername(currentPrincipalName);
			return githubUser;

	}
	
}

