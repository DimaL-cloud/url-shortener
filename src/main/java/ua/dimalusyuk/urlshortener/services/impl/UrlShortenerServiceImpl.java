package ua.dimalusyuk.urlshortener.services.impl;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ua.dimalusyuk.urlshortener.exceptions.HashNotFoundException;
import ua.dimalusyuk.urlshortener.services.UrlShortenerService;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private final RedisTemplate<String, String> redisTemplate;

    private final HashFunction hashFunction = Hashing.sha256();

    public static final int HASH_LENGTH = 6;

    public String shorten(String url) {
        String hash = hash(url);

        redisTemplate.opsForValue().set(hash, url);

        return hash;
    }

    public String resolve(String hash) {
        String url = redisTemplate.opsForValue().get(hash);

        if (url == null) {
            throw new HashNotFoundException(hash);
        }

        return url;
    }

    private String hash(String url) {
        return hashFunction
                .hashString(url, StandardCharsets.UTF_8)
                .toString()
                .substring(0, HASH_LENGTH);
    }
}
