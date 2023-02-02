package io.kristaps.urlshort;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortController {
    private final Service service;

    public ShortController(Service service) {
        this.service = service;
    }

    @GetMapping("/generate")
    public String shortenUrl(@RequestBody String link) {
        return service.shortenUrl(link);
    }
}
