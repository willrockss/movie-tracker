package io.movietracker.core.infra.repositoryimpl;

import io.movietracker.core.domain.entity.VideoContent;
import io.movietracker.core.domain.repository.VideoContentRepository;
import io.movietracker.core.domain.vo.VideoId;
import io.movietracker.core.infra.jpa.VideoContentJpaMapper;
import io.movietracker.core.infra.jpa.repository.VideoContentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VideoContentJpaBasedRepositoryAdapter implements VideoContentRepository {

    private final VideoContentJpaRepository jpaRepository;
    private final VideoContentJpaMapper jpaMapper;

    @Override
    public boolean isVideoPresent(VideoId videoId) {
        return jpaRepository.existsByVideoId(videoId.value());
    }

    @Override
    public Optional<VideoContent> findByVideoId(VideoId videoId) {
        return jpaRepository
                .findByVideoId(videoId.value())
                .map(jpaMapper::map);
    }

    @Override
    public Collection<VideoContent> getAllByIds(Collection<VideoId> videoIds) {
        Collection<String> videoIdsStr = videoIds.stream().map(VideoId::value).collect(Collectors.toSet());
        Collection<io.movietracker.core.infra.jpa.VideoContent> jpaResp = jpaRepository.findAllByVideoIdIn(videoIdsStr);
        return jpaResp.stream().map(jpaMapper::map).toList();
    }
}
