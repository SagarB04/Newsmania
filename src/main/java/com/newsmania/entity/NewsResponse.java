package com.newsmania.entity;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewsResponse {

	public ArrayList<Article> articles;

}
