package ua.dimalusyuk.urlshortener.payload.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlResponse {

    private String hash;
}
