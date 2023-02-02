package io.kristaps.urlshort;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class RedirectController {
    private final Service service;

    public RedirectController(Service service) {
        this.service = service;
    }

    @GetMapping("/{shortUrl}")
    public void redirectToOriginal(HttpServletResponse httpServletResponse, @PathVariable String shortUrl) throws IOException {
        String originalLink = service.getOriginalLink(shortUrl);
        httpServletResponse.sendRedirect(originalLink);
        httpServletResponse.setStatus(302);
    }
}
