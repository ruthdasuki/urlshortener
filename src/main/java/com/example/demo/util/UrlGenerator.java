package com.example.demo.util;

import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class UrlGenerator {
    private static final String BASE_URL = "http://localhost:8080/";

    public String getRandomAlias() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public String generateShortUrl(String alias) {
        return BASE_URL + alias;
    }
}
