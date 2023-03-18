package io.movietracker.core.domain.error;

import lombok.Getter;

import java.util.Map;

public class MovieTrackerError extends RuntimeException {
    @Getter
    private String errorCode;

    private Map<String, Object> context = Map.of();

    public MovieTrackerError(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public MovieTrackerError(String message, String errorCode, Map<String, Object> context) {
        super(message);
        this.errorCode = errorCode;
        this.context = context;
    }
}
