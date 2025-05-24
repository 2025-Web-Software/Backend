package com.example.dailywidget.news.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import com.example.dailywidget.news.dto.AiRequestDto;
import com.example.dailywidget.news.dto.AiResponseDto;

@Service
public class NewsAnalysisService {

    private final RestTemplate restTemplate = new RestTemplate();

    public AiResponseDto analyzeNews(String content) {
        String aiUrl = "http://localhost:5000/analyze"; // Flask API 주소

        AiRequestDto request = new AiRequestDto(content);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AiRequestDto> entity = new HttpEntity<>(request, headers);
        ResponseEntity<AiResponseDto> response = restTemplate.postForEntity(aiUrl, entity, AiResponseDto.class);

        return response.getBody();
    }
}