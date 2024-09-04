package com.newsmania.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Article {
	public Source source;
	public String author;
	public String title;
	public String description;
	public String url;
	public String urlToImage;
	public LocalDate publishedAt;
	public String content;

	@Override
	public String toString() {
		return "Article [source=" + source + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", url=" + url + ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + ", content="
				+ content + "]";
	}

	@Getter
	@Setter
	@ToString
	public static class Source {
		public String name;
	}
}