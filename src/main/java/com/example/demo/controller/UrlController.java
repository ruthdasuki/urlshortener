package com.example.demo.controller;

import com.example.demo.DTO.NewUrlDTO;
import com.example.demo.DTO.UpdateUrlDTO;
import com.example.demo.DTO.UrlDTO;
import com.example.demo.DTO.UrlWithAnalyticsDTO;
import com.example.demo.converter.UrlMapper;
import com.example.demo.converter.UrlWithAnalyticsMapper;
import com.example.demo.model.UpdateUrl;
import com.example.demo.model.Url;
import com.example.demo.model.UrlWithAnalytics;
import com.example.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/url")
public class UrlController {
    private final UrlService urlService;
    private final UrlMapper urlMapper;
    private final UrlWithAnalyticsMapper urlWithAnalyticsMapper;

    @Autowired
    public UrlController(UrlService urlService, UrlMapper urlMapper, UrlWithAnalyticsMapper urlWithAnalyticsMapper) {
        this.urlService = urlService;
        this.urlMapper = urlMapper;
        this.urlWithAnalyticsMapper = urlWithAnalyticsMapper;
    }

    @GetMapping
    public List<UrlDTO> getAllUrls() {
        List<Url> urlList = urlService.getAllUrls();
        return urlList.stream().map(urlMapper::mapToDTO).toList();
    }

    @GetMapping("/{userId}")
    public List<UrlWithAnalyticsDTO> getUrlsByUserId(@PathVariable Long userId) {
        List<UrlWithAnalytics> userUrlsWithAnalytics = urlService.getUrlsWithAnalytics(userId);
        return userUrlsWithAnalytics.stream().map(urlWithAnalyticsMapper::toUrlAnalyticsDTO).toList();
    }

    @PostMapping
    public UrlDTO addUrl(@RequestBody NewUrlDTO newUrlDTO) {
        Url url = urlMapper.mapToEntity(newUrlDTO);
        return urlService.addUrl(url);
    }

    @PutMapping
    public UrlDTO updateUrl(@RequestBody UpdateUrlDTO updateUrlDTO) {
        UpdateUrl updateUrl = urlMapper.mapToEntity(updateUrlDTO);
        Url updatedUrl = urlService.updateUrl(updateUrl);
        return urlMapper.mapToDTO(updatedUrl);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);
    }
}
