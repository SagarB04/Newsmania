package com.newsmania.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.newsmania.entity.Article;
import com.newsmania.entity.NewsResponse;

@Service
public class NewsmaniaService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String apiKey = "dba73668ac494f5e9f5ba5e6a743fd30";
	private static final String API = "https://newsapi.org/v2/everything?q=KEYWORD&sortBy=publishedAt&language=en&searchIn=title,description&apiKey=API_KEY";

	public ArrayList<Article> getNews() {
		String keyword = "india";
		String finalApi = API.replace("KEYWORD", keyword).replace("API_KEY", apiKey);

		ResponseEntity<NewsResponse> resp = restTemplate.exchange(finalApi, HttpMethod.GET, null, NewsResponse.class);
		NewsResponse body = resp.getBody();

		return body.articles;

	}

	public ArrayList<Article> getNewsbyKewword(String keyword) {

		String finalApi = API.replace("KEYWORD", keyword).replace("API_KEY", apiKey);

		ResponseEntity<NewsResponse> resp = restTemplate.exchange(finalApi, HttpMethod.GET, null, NewsResponse.class);
		NewsResponse body = resp.getBody();

		return body.articles;

	}

}
