package io.movietracker.core.application.response;

import io.movietracker.core.domain.entity.WatchListEntry;
import org.springframework.data.domain.Page;

public record GetWatchListEntriesResponse(
        Page<WatchListEntry> page
) {
}
