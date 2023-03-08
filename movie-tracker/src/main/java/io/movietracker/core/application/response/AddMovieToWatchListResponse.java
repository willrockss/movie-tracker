package io.movietracker.core.application.response;

import io.movietracker.core.domain.entity.WatchListEntry;

public record AddMovieToWatchListResponse(
        WatchListEntry createdEntry
) {
}
