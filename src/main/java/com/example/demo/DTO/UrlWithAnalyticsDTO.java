package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlWithAnalyticsDTO {
    @JsonProperty("url_id")
    private Long urlId;
    @JsonProperty("short_url")
    private String shortUrl;
    @JsonProperty("long_url")
    private String longUrl;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("expires_at")
    private String expiresAt;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("url_analytic_id")
    private Long urlAnalyticId;
    @JsonProperty("total_clicks")
    private int totalClicks = 0;
    @JsonProperty("last_accessed")
    private String lastAccessed;

    public UrlWithAnalyticsDTO() {
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl(String longUrl) {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUrlAnalyticId() {
        return urlAnalyticId;
    }

    public void setUrlAnalyticId(Long urlAnalyticId) {
        this.urlAnalyticId = urlAnalyticId;
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
