package com.example.demo.shared.presentation.handleExceptions;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseException {
    private final Date timestamp;
    private final int status;
    private final Object error;
    private final String path;

    public static ResponseException create(HttpStatus status, Object error, String path) {
        return new ResponseException(new Date(), status.value(), error, path);
    }
}
