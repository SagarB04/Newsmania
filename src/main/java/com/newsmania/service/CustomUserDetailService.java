package com.newsmania.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newsmania.entity.CustomUserDetails;
import com.newsmania.entity.User;
import com.newsmania.entity.UserDto;
import com.newsmania.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = repo.findByUsername(username);

		if (user.isPresent()) {
			return new CustomUserDetails(user.get());
		} else {
			throw new UsernameNotFoundException(username);
		}
	}

	

}
