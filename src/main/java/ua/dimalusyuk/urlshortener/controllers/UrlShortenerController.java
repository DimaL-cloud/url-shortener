package ua.dimalusyuk.urlshortener.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dimalusyuk.urlshortener.payload.requests.UrlRequest;
import ua.dimalusyuk.urlshortener.payload.responses.UrlResponse;
import ua.dimalusyuk.urlshortener.services.UrlShortenerService;

import java.net.URI;

@RestController
@RequestMapping("api/url")
@RequiredArgsConstructor
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    @PostMapping
    public ResponseEntity<UrlResponse> shorten(@RequestBody UrlRequest urlRequest) {
        String hash = urlShortenerService.shorten(urlRequest.getUrl());

        UrlResponse urlResponse = new UrlResponse(hash);

        return new ResponseEntity<>(urlResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<Void> resolve(@PathVariable String hash) {
        String url = urlShortenerService.resolve(hash);

        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(url))
                .header(HttpHeaders.CONNECTION, "close")
                .build();
    }
}
