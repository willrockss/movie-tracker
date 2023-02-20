package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import io.movietracker.core.domain.vo.VideoId;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WatchListEntry {
    private final Long id;
    private final VideoId videoId;
    private final ProfileId profileId;
    private final PersonId personId;
    private String preComment;
}
