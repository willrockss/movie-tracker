package io.movietracker.core.application.request;

public record AddMovieToWatchListRequest(
        String videoId,
        String preComment
) {
}
