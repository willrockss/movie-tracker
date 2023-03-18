package io.movietracker.core.domain.error;

import io.movietracker.core.domain.vo.VideoId;

import java.util.Map;

public class VideoIsNotPresentError extends MovieTrackerError {

    public VideoIsNotPresentError(VideoId videoId) {
        this("Видео " + videoId.value() + " не найдено", "video.is.not.present", Map.of("videoId", videoId.value()));
    }
    private VideoIsNotPresentError(String message, String errorCode, Map<String, Object> context) {
        super(message, errorCode, context);
    }
}
