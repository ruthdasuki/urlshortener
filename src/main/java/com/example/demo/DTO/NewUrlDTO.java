package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewUrlDTO {
    @JsonProperty("long_url")
    private String longUrl;
    @JsonProperty("alias")
    private String alias;
    @JsonProperty("user_id")
    private Long userId;
    private Long urlAnalyticId;

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
}
