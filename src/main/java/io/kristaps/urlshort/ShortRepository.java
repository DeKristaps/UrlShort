package io.kristaps.urlshort;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ShortRepository {
    HashMap<String, String> urls = new HashMap<>();

    public void addUrls(String shortUrl, String url) {
        urls.put(shortUrl, url);
    }

    public String getUrl(String shortUrl) {
        return urls.get(shortUrl);
    }
}
