package com.example.demo.controller;

import com.example.demo.service.AnalyticsService;
import com.example.demo.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class RedirectController {
    private final UrlService urlService;
    private final AnalyticsService urlAnalyticsService;

    @Autowired
    public RedirectController(UrlService urlService, AnalyticsService urlAnalyticsService) {
        this.urlService = urlService;
        this.urlAnalyticsService = urlAnalyticsService;
    }

    @GetMapping(path = "{id}")
    public void redirect(@PathVariable String id, HttpServletResponse response) throws IOException {
        try {
            String shortUrl = "http://localhost:8080/" + id;
            String longUrl = urlService.getLongUrl(shortUrl);

            urlAnalyticsService.saveUrlAnalytics(shortUrl);

            response.setStatus(HttpServletResponse.SC_FOUND);
            response.sendRedirect(longUrl);
        } catch (IllegalStateException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
        }
    }
}
