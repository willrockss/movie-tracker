package io.movietracker.core.infra.jpa.repository;

import io.movietracker.core.infra.jpa.VideoContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface VideoContentJpaRepository extends JpaRepository<VideoContent, Long> {
    boolean existsByVideoId(String videoId);
    Optional<VideoContent> findByVideoId(String videoId);
    Collection<VideoContent> findAllByVideoIdIn(Collection<String> videoIds);
}
