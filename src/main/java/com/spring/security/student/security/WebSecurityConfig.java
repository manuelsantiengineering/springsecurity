//package com.spring.security.student.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import com.spring.security.student.authprovider.CustomAuthenticationProvider;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true) //Process requests before authorization
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private CustomAuthenticationProvider authenticationProvider;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()
//		.antMatchers("/","/home","/time").permitAll()
//		.anyRequest().authenticated()
//		.and()
//		.authorizeRequests()
//		.antMatchers("/admin/**")
//		.hasRole("ADMIN")
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.permitAll()
//		.and()
//		.logout()
//		.permitAll();
//	}
//
////	@Bean
////	@Override
////	protected UserDetailsService userDetailsService() {
////		UserDetails user = User
////				.withDefaultPasswordEncoder()
////				.username("user")
////				.password("password")
////				.roles("USER")
////				.username("admin")
////				.password("admin")
////				.roles("ADMIN")
////				.build();
////		return new InMemoryUserDetailsManager(user);
////	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider);
//	}
//	
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/templates/**","/assets/**");
//	}
//	
//	
//	
//	
//}
