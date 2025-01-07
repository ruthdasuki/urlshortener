package com.example.demo.service;

import com.example.demo.model.Url;
import com.example.demo.model.Analytics;
import com.example.demo.repository.UrlAnalyticsRepository;
import com.example.demo.repository.UrlRepository;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    private final UrlAnalyticsRepository urlAnalyticsRepository;
    private final UrlRepository urlRepository;

    public AnalyticsService(UrlAnalyticsRepository urlAnalyticsRepository, UrlRepository urlRepository) {
        this.urlAnalyticsRepository = urlAnalyticsRepository;
        this.urlRepository = urlRepository;
    }

    public void saveUrlAnalytics(String shortUrl) {
        Url url = urlRepository
                .findUrlByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("Short Url not found"));

        Analytics urlAnalytics = urlAnalyticsRepository
                .findByShortUrl(url.getShortUrl())
                .orElse(new Analytics(url.getShortUrl()));

        urlAnalytics.setTotalClicks(urlAnalytics.getTotalClicks() + 1);
        urlAnalytics.setLastAccessed(String.valueOf(System.currentTimeMillis()));
        urlAnalyticsRepository.save(urlAnalytics);
    }

    public Analytics getUrlAnalytics(String shortUrl) {
        return urlAnalyticsRepository
                .findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("Short Url not found"));
    }
}
