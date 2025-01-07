package com.example.demo.controller;

import com.example.demo.DTO.AnalyticsDTO;
import com.example.demo.converter.AnalyticsMapper;
import com.example.demo.model.Analytics;
import com.example.demo.service.AnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;
    private final AnalyticsMapper urlAnalyticsMapper;

    public AnalyticsController(AnalyticsService analyticsService, AnalyticsMapper urlAnalyticsMapper) {
        this.analyticsService = analyticsService;
        this.urlAnalyticsMapper = urlAnalyticsMapper;
    }

    @GetMapping(path = "{id}")
    public AnalyticsDTO getAnalytics(@PathVariable String id) {
        String shortUrl = "http://localhost:8080/" + id;
        Analytics analytics = analyticsService.getUrlAnalytics(shortUrl);
        return urlAnalyticsMapper.toAnalyticsDTO(analytics);
    }
}
