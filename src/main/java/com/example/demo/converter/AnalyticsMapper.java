package com.example.demo.converter;

import com.example.demo.DTO.AnalyticsDTO;
import com.example.demo.model.Analytics;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsMapper {
    public AnalyticsDTO toAnalyticsDTO(Analytics analytics) {
        AnalyticsDTO urlAnalyticsDTO = new AnalyticsDTO(analytics.getShortUrl());
        urlAnalyticsDTO.setUrlAnalyticId(analytics.getAnalyticId());
        urlAnalyticsDTO.setTotalClicks(analytics.getTotalClicks());
        urlAnalyticsDTO.setLastAccessed(analytics.getLastAccessed());
        return urlAnalyticsDTO;
    }
}
