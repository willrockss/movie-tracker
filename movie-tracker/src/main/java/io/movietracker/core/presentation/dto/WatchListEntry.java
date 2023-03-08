package io.movietracker.core.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchListEntry {
    private Long id;
    private String videoId;
    private String preComment;
    private OffsetDateTime addedAt;
}
