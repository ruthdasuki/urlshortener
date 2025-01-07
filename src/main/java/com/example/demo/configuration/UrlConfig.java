package com.example.demo.configuration;

import com.example.demo.model.Url;
import com.example.demo.repository.UrlRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlConfig {
    @Bean
    CommandLineRunner commandLineRunnerForUrl(UrlRepository repository) {
        return args -> {
            Url firstUrl = new Url(
                    "http://localhost:8080/d5076e",
                    "https://leetcode.com/problems/encode-and-decode-tinyurl/description/",
                    "",
                    0L
            );

            repository.save(firstUrl);
        };
    }
}