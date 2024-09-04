package com.newsmania.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newsmania.entity.User;
import com.newsmania.entity.UserDto;
import com.newsmania.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	PasswordEncoder passwordencoder;

	public boolean usernameExists(String username) {
		return repo.findByUsername(username).isPresent();
	}

	public Boolean saveUser(UserDto userdto) {
		User user = new User(

				userdto.getId(), 
				userdto.getName(), 
				userdto.getUsername(), 
				passwordencoder.encode(userdto.getPassword())

		);

		try {
			repo.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
