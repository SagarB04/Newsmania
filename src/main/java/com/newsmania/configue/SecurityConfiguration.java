package com.newsmania.configue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.newsmania.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	CustomUserDetailService userDetailsService;

	@Bean
	UserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Bean
	AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());

		return provider;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(request) -> request.requestMatchers("/newsmania/signin", "/newsmania/signup").permitAll().anyRequest().authenticated())

				.formLogin((form) -> form.loginPage("/newsmania/signin").defaultSuccessUrl("/newsmania/", true).permitAll())

				.logout((logout) -> logout.permitAll());

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;
	}

}
