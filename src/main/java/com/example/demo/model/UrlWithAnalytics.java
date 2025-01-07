package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class UrlWithAnalytics {
    @Id
    @SequenceGenerator(
            name = "url_analytic_sequence",
            sequenceName = "url_analytic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "url_analytic_sequence"
    )
    private Long urlAnalyticId;
    private Long urlId;
    private String shortUrl;
    private String longUrl;
    private String alias;
    private String expiresAt;
    private String createdAt;
    private Long userId;
    private int totalClicks = 0;
    private String lastAccessed;

    public UrlWithAnalytics() {
    }

    public UrlWithAnalytics(
            Long urlId,
            String shortUrl,
            String longUrl,
            String alias,
            String expiresAt,
            String createdAt,
            Long userId,
            int totalClicks,
            String lastAccessed
    ) {
        this.urlId = urlId;
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.alias = alias;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
        this.userId = userId;
        this.totalClicks = totalClicks;
        this.lastAccessed = lastAccessed;
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setUrlId(Long urlId) {
        this.urlId = urlId;
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

    public String getLongUrl() {
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
