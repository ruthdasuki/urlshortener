package com.example.demo.model;

public class UpdateUrl {
    private String shortUrl;
    private String newAlias;

    public UpdateUrl(String shortUrl, String newAlias) {
        this.shortUrl = shortUrl;
        this.newAlias = newAlias;
    }

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
