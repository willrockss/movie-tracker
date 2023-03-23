package io.movietracker.core.presentation.dto;

import lombok.Builder;

import java.time.OffsetDateTime;

@Builder
public record WatchListEntry(
    Long id,
    String videoId,
    String fullTitle,
    String preComment,
    OffsetDateTime addedAt
) {}
