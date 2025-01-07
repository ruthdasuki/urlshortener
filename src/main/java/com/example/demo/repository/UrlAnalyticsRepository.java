package com.example.demo.repository;

import com.example.demo.model.Analytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UrlAnalyticsRepository extends JpaRepository<Analytics, Long> {
    Optional<Analytics> findByShortUrl(String shortUrl);
}
