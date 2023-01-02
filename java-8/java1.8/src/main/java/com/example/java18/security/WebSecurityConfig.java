package com.example.java18.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/api/**")
			.permitAll()
			.and()
			/*.authorizeRequests()
			.antMatchers("/api/users/create")
			.permitAll()
			.and()
			.authorizeRequests()
			.antMatchers("/api/category/**")
			.permitAll()
			.and()
			.authorizeRequests()
			.antMatchers("/login")
			.permitAll()
			.antMatchers("/api/**")
			.hasAnyAuthority("ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SELLER")
			.anyRequest()
			.authenticated()
			.and()
			*/.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.and()
			.rememberMe()
			.key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
			.and()
			.logout()
			.permitAll();

		http.authorizeRequests();

		http.headers().frameOptions().sameOrigin();

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/api/**");
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

}
