package com.example.demo.service;

import com.example.demo.DTO.UrlDTO;
import com.example.demo.converter.UrlMapper;
import com.example.demo.model.UpdateUrl;
import com.example.demo.model.Url;
import com.example.demo.model.Analytics;
import com.example.demo.model.UrlWithAnalytics;
import com.example.demo.repository.UrlAnalyticsRepository;
import com.example.demo.repository.UrlRepository;
import com.example.demo.util.UrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrlService {
    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;
    private final UrlAnalyticsRepository urlAnalyticsRepository;
    private final UrlGenerator urlGenerator;

    @Autowired
    public UrlService(
            UrlRepository urlRepository,
            UrlMapper urlMapper,
            UrlAnalyticsRepository urlAnalyticsRepository,
            UrlGenerator urlGenerator
    ) {
        this.urlRepository = urlRepository;
        this.urlMapper = urlMapper;
        this.urlAnalyticsRepository = urlAnalyticsRepository;
        this.urlGenerator = urlGenerator;
    }

    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    public List<Url> getUrlsByUserId(Long userId) {
        return urlRepository.findByUserId(userId);
    }

    public UrlDTO addUrl(Url url) {
        Optional<Url> urlOptional = urlRepository.findUrlByShortUrl(url.getShortUrl());
        if (urlOptional.isPresent()) {
            throw new IllegalStateException("Short URL already exists");
        }
        urlRepository.save(url);

        Optional<Analytics> analyticsOptional = urlAnalyticsRepository.findByShortUrl(url.getShortUrl());
        if (analyticsOptional.isEmpty()) {
            Analytics analytics = new Analytics();
            analytics.setShortUrl(url.getShortUrl());
            analytics.setTotalClicks(0);
            analytics.setLastAccessed(null);
            urlAnalyticsRepository.save(analytics);
        }

        return urlMapper.mapToDTO(url);
    }

    public String getLongUrl(String shortUrl) {
        Optional<Url> urlOptional = urlRepository.findUrlByShortUrl(shortUrl);
        if (urlOptional.isEmpty()) {
            throw new IllegalStateException("Short URL does not exist");
        }
        return urlOptional.get().getLongUrl();
    }

    public void deleteUrl(Long id) {
        boolean exists = urlRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("URL with id " + id + " does not exist");
        }
        urlRepository.deleteById(id);
    }

    public List<UrlWithAnalytics> getUrlsWithAnalytics(Long userId) {
        List<Url> urls = urlRepository.findByUserId(userId);
        return urls.stream()
                .map(url -> {
                    Analytics analytics = urlAnalyticsRepository.findByShortUrl(url.getShortUrl())
                            .orElse(new Analytics());

                    UrlWithAnalytics urlWithAnalytics = new UrlWithAnalytics();
                    urlWithAnalytics.setUrlId(url.getUrlId());
                    urlWithAnalytics.setShortUrl(url.getShortUrl());
                    urlWithAnalytics.setLongUrl(url.getLongUrl());
                    urlWithAnalytics.setAlias(url.getAlias());
                    urlWithAnalytics.setExpiresAt(url.getExpiresAt());
                    urlWithAnalytics.setCreatedAt(url.getCreatedAt());
                    urlWithAnalytics.setUserId(url.getUserId());
                    urlWithAnalytics.setUrlAnalyticId(analytics.getAnalyticId());
                    urlWithAnalytics.setTotalClicks(analytics.getTotalClicks());
                    urlWithAnalytics.setLastAccessed(analytics.getLastAccessed());
                    return urlWithAnalytics;
                })
                .collect(Collectors.toList());
    }

    public Url updateUrl(UpdateUrl updateUrl) {
        Url url = urlRepository.findUrlByShortUrl(updateUrl.getShortUrl())
                .orElseThrow(() -> new IllegalStateException("Short URL does not exist"));

        if (urlRepository.existsByAlias(updateUrl.getNewAlias())) {
            throw new IllegalStateException("Alias already exists");
        }

        url.setAlias(updateUrl.getNewAlias());
        url.setShortUrl(urlGenerator.generateShortUrl(updateUrl.getNewAlias()));
        return urlRepository.save(url);
    }
}
