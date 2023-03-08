package io.movietracker.core.application.request;

public record GetWatchListEntriesRequest(
        Integer page,
        Integer size
) {
    public GetWatchListEntriesRequest() {
        this(null, null);
    }
}
