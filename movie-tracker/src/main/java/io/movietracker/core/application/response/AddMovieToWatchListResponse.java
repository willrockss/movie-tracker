package io.movietracker.core.application.response;

public record AddMovieToWatchListResponse(
        Long id,
        String videoId,
        String preComment
) {
}
