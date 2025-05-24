package com.example.dailywidget.controller;

import com.example.dailywidget.news.dto.AiResponseDto;
import com.example.dailywidget.news.service.NewsAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class NewsTestController {

    private final NewsAnalysisService analysisService;

    @PostMapping("/analyze")
    public AiResponseDto testAnalyze(@RequestBody String content) {
        return analysisService.analyzeNews(content);
    }
}