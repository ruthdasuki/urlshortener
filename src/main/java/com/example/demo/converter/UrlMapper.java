package com.example.demo.converter;

import com.example.demo.DTO.NewUrlDTO;
import com.example.demo.DTO.UpdateUrlDTO;
import com.example.demo.DTO.UrlDTO;
import com.example.demo.model.UpdateUrl;
import com.example.demo.model.Url;
import com.example.demo.util.UrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class UrlMapper {
    private final UrlGenerator urlGenerator;

    @Autowired
    public UrlMapper(UrlGenerator urlGenerator) {
        this.urlGenerator = urlGenerator;
    }

    public Url mapToEntity(NewUrlDTO newUrlDTO) {
        String alias = (newUrlDTO.getAlias() != null && !newUrlDTO.getAlias().isBlank())
                ? newUrlDTO.getAlias()
                : urlGenerator.getRandomAlias();

        String shortUrl = urlGenerator.generateShortUrl(alias);

        String createdAt = LocalDateTime.now().toString();
        String expiresAt = LocalDateTime.now().plusDays(7).toString();

        return new Url(
                shortUrl,
                newUrlDTO.getLongUrl(),
                alias,
                expiresAt,
                createdAt,
                newUrlDTO.getUserId()
        );
    }

    public UrlDTO mapToDTO(Url url) {
        UrlDTO urlDTO = new UrlDTO();
        urlDTO.setUrlId(url.getUrlId());
        urlDTO.setShortUrl(url.getShortUrl());
        urlDTO.setLongUrl(url.getLongUrl());
        urlDTO.setAlias(url.getAlias());
        urlDTO.setExpiresAt(url.getExpiresAt());
        urlDTO.setCreatedAt(url.getCreatedAt());
        urlDTO.setUserId(url.getUserId());
        return urlDTO;
    }

    public UpdateUrl mapToEntity(UpdateUrlDTO updateUrlDTO) {
        return new UpdateUrl(
                updateUrlDTO.getShortUrl(),
                updateUrlDTO.getNewAlias()
        );
    }
}
