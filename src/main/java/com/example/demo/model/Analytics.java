package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table
public class Analytics {
    @Id
    @SequenceGenerator(
            name = "analytic_sequence",
            sequenceName = "analytic_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "analytic_sequence"
    )
    private Long analyticId;
    private String shortUrl;
    private int totalClicks = 0;
    private String lastAccessed;

    public Analytics() {
    }

    public Analytics(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Long getAnalyticId() {
        return analyticId;
    }

    public void setAnalyticId(Long analyticId) {
        this.analyticId = analyticId;
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
