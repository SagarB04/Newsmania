package com.newsmania.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newsmania.entity.Article;
import com.newsmania.service.NewsmaniaService;

@Controller
@RequestMapping("/newsmania")
public class NewmaniaController {

	@Autowired
	NewsmaniaService service;

	@GetMapping("/")
	public String getNews(Model model) {

		ArrayList<Article> articles = service.getNews();
		model.addAttribute("articles", articles);
		return "index";
	}
	
	@GetMapping("/news/{keyword}")
	public String getNewsbyKeyword(Model model, @PathVariable String keyword) {
		
		ArrayList<Article> articles = service.getNewsbyKewword(keyword);
		model.addAttribute("articles", articles);
		return "index";
	}
	
	@GetMapping("/error")
    public String handleError() {
        return "error"; 
    }
}
