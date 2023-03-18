package io.movietracker.core.domain.repository;

import io.movietracker.core.domain.vo.VideoId;

public interface VideoContentRepository {
    boolean isVideoPresent(VideoId videoId);
}
