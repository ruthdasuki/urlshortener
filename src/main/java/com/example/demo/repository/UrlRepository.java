package com.example.demo.repository;

import com.example.demo.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findUrlByShortUrl(String shortUrl);
    List<Url> findByUserId(Long userId);
    boolean existsByAlias(String alias);
}
