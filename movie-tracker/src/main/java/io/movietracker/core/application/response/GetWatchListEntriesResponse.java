package io.movietracker.core.application.response;

import io.movietracker.core.domain.entity.VideoContent;
import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.vo.VideoId;
import org.springframework.data.domain.Page;

import java.util.Map;

public record GetWatchListEntriesResponse(
        Page<WatchListEntry> page,
        Map<VideoId, VideoContent> videoContentMap
) {
}
