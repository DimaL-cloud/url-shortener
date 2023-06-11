package ua.dimalusyuk.urlshortener.services;

public interface UrlShortenerService {
    String shorten(String url);

    String resolve(String hash);
}
