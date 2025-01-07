package com.example.demo.converter;

import com.example.demo.DTO.UrlWithAnalyticsDTO;
import com.example.demo.model.UrlWithAnalytics;
import org.springframework.stereotype.Component;

@Component
public class UrlWithAnalyticsMapper {
    public UrlWithAnalyticsDTO toUrlAnalyticsDTO(UrlWithAnalytics urlWithAnalytics) {
        UrlWithAnalyticsDTO urlWithAnalyticsDTO = new UrlWithAnalyticsDTO();
        urlWithAnalyticsDTO.setUrlId(urlWithAnalytics.getUrlId());
        urlWithAnalyticsDTO.setShortUrl(urlWithAnalytics.getShortUrl());
        urlWithAnalyticsDTO.setLongUrl(urlWithAnalytics.getLongUrl());
        urlWithAnalyticsDTO.setAlias(urlWithAnalytics.getAlias());
        urlWithAnalyticsDTO.setExpiresAt(urlWithAnalytics.getExpiresAt());
        urlWithAnalyticsDTO.setCreatedAt(urlWithAnalytics.getCreatedAt());
        urlWithAnalyticsDTO.setUserId(urlWithAnalytics.getUserId());
        urlWithAnalyticsDTO.setUrlAnalyticId(urlWithAnalytics.getUrlAnalyticId());
        urlWithAnalyticsDTO.setTotalClicks(urlWithAnalytics.getTotalClicks());
        urlWithAnalyticsDTO.setLastAccessed(urlWithAnalytics.getLastAccessed());
        return urlWithAnalyticsDTO;
    }
}
