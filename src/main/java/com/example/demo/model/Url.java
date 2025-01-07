package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Url {
    @Id
    @SequenceGenerator(
            name = "url_sequence",
            sequenceName = "url_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "url_sequence"
    )
    private Long urlId;
    private String shortUrl;
    private String longUrl;
    private String alias;
    private String expiresAt;
    private String createdAt;
    private Long userId;

    public Url() {
    }

    public Url(String shortUrl,
               String longUrl,
               String alias,
               Long userId
    ) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.alias = alias;
        this.userId = userId;
    }

    public Url(String shortUrl,
               String longUrl,
               String alias,
               String expiresAt,
               String createdAt,
               Long userId
    ) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.alias = alias;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public Long getUrlId() {
        return urlId;
    }

    public void setId(Long urlId) {
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
