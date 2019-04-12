package com.spring.security.student.authprovider;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private ThirdPartyAuthProviderClient thirdPartyAuthProviderClient;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		Object password = authentication.getCredentials();
		if(thirdPartyAuthProviderClient.shouldAuthenticate(name, password)) {
			return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
		}
		else {
			System.out.println("Authentication failed for user: " + name);
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
