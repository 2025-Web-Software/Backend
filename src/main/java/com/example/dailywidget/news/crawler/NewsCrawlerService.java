package com.example.dailywidget.news.crawler;

import com.example.dailywidget.news.dto.CrawledNewsDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsCrawlerService {

    public List<CrawledNewsDto> crawlNaverHeadlines() {
        List<CrawledNewsDto> result = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://news.naver.com/").get();
            Elements headlines = doc.select("a[href*='/read?']"); // 주요 기사 링크

            for (var link : headlines) {
                String title = link.text();
                String url = link.absUrl("href");

                // 기사 본문 추출
                Document newsDoc = Jsoup.connect(url).get();
                String content = newsDoc.select("article").text();

                if (content.length() > 100) { // 간단한 필터
                    result.add(new CrawledNewsDto(title, url, content));
                }

                if (result.size() >= 5) break; // 테스트용으로 5개만
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}