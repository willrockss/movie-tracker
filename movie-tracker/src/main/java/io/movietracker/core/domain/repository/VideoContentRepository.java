package io.movietracker.core.domain.repository;

import io.movietracker.core.domain.entity.VideoContent;
import io.movietracker.core.domain.vo.VideoId;

import java.util.Collection;
import java.util.Optional;

public interface VideoContentRepository {
    boolean isVideoPresent(VideoId videoId);
    Optional<VideoContent> findByVideoId(VideoId videoId);
    Collection<VideoContent> getAllByIds(Collection<VideoId> videoIds) ;
}
