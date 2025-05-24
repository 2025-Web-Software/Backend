package com.example.dailywidget.news.dto;

public class CrawledNewsDto {
    private String title;
    private String url;
    private String content;

    public CrawledNewsDto(String title, String url, String content) {
        this.title = title;
        this.url = url;
        this.content = content;
    }

    // getters, setters
}