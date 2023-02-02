package io.kristaps.urlshort;

import org.springframework.util.DigestUtils;

@org.springframework.stereotype.Service
public class Service {
    private final ShortRepository repository;

    public Service(ShortRepository repository) {
        this.repository = repository;
    }

    public String shortenUrl(String link) {
        String shortLink = md5Encode(link);
        repository.addUrls(shortLink, link);
        return "http://localhost:8080/" + shortLink;
    }

    public String getOriginalLink(String shortUrl) {
        return repository.getUrl(shortUrl).trim();
    }

    private String md5Encode(String link) {
        return DigestUtils.md5DigestAsHex(link.getBytes()).toUpperCase().substring(0, 9);
    }

}
