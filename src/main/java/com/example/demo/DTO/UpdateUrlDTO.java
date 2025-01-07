package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUrlDTO {
    @JsonProperty("short_url")
    private String shortUrl;
    @JsonProperty("new_alias")
    private String newAlias;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getNewAlias() {
        return newAlias;
    }

    public void setNewAlias(String newAlias) {
        this.newAlias = newAlias;
    }
}
