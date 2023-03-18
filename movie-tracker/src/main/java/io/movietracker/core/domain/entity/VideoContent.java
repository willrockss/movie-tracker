package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.FullTitle;
import io.movietracker.core.domain.vo.VideoId;

import java.util.Map;

public class VideoContent {
    private VideoId id;

    private VideoType type;

    private FullTitle fullTitle;

    private Map<String, Object> info;
}
