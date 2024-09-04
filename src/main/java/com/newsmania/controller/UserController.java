package com.newsmania.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsmania.entity.UserDto;
import com.newsmania.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/newsmania")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/signin")
	public String signin() {
		return "signin";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute UserDto userdto, Model model) {

		if (service.usernameExists(userdto.getUsername())) {
			model.addAttribute("message", "User already exists");
			return "signup";
		} else {
			Boolean resp = service.saveUser(userdto);

			if (resp) {
				model.addAttribute("message", "Rigistered successfull, please login!");
				return "signin";
			} else {
				model.addAttribute("message", "Something went wrong!");
				return "signup";
			}

		}
	}

}
