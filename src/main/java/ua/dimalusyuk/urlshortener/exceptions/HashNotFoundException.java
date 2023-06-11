package ua.dimalusyuk.urlshortener.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class HashNotFoundException extends RuntimeException{
    private final HttpStatusCode errorCode = HttpStatus.NOT_FOUND;

    public HashNotFoundException(String hash) {
        super("Hash " + hash + " not found");
    }
}
