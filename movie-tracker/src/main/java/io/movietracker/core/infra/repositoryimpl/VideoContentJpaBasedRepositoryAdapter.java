package io.movietracker.core.infra.repositoryimpl;

import io.movietracker.core.domain.repository.VideoContentRepository;
import io.movietracker.core.domain.vo.VideoId;
import io.movietracker.core.infra.jpa.repository.VideoContentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VideoContentJpaBasedRepositoryAdapter implements VideoContentRepository {

    private final VideoContentJpaRepository jpaRepository;

    @Override
    public boolean isVideoPresent(VideoId videoId) {
        return jpaRepository.existsByVideoId(videoId.value());
    }
}
