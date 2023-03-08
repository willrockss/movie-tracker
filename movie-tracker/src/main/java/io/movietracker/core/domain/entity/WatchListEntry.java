package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import io.movietracker.core.domain.vo.VideoId;
import io.movietracker.core.domain.vo.WatchListEntryId;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
public class WatchListEntry {
    private final WatchListEntryId id;
    private final VideoId videoId;
    private final ProfileId profileId;

    private String preComment;
    private ZonedDateTime addedAt;
    private PersonId updatedBy;
}
