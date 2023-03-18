package io.movietracker.core.infra.jpa.repository;

import io.movietracker.core.infra.jpa.VideoContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoContentJpaRepository extends JpaRepository<VideoContent, Long> {
    boolean existsByVideoId(String videoId);
}
