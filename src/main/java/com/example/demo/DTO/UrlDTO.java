package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlDTO {
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
    private Long userId;
    public UrlDTO() {
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
}
