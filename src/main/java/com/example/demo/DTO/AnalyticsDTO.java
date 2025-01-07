package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnalyticsDTO {
    @JsonProperty("url_analytic_id")
    private Long urlAnalyticId;
    @JsonProperty("short_url")
    private String shortUrl;
    @JsonProperty("total_clicks")
    private int totalClicks = 0;
    @JsonProperty("last_accessed")
    private String lastAccessed;

    public AnalyticsDTO() {
    }

    public AnalyticsDTO(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getUrlAnalyticId() {
        return urlAnalyticId;
    }

    public void setUrlAnalyticId(Long urlAnalyticId) {
        this.urlAnalyticId = urlAnalyticId;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }

    public String getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(String lastAccessed) {
        this.lastAccessed = lastAccessed;
    }
}
