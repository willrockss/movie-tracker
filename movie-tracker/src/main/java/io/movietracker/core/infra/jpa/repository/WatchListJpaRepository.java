package io.movietracker.core.infra.jpa.repository;

import io.movietracker.core.infra.jpa.WatchListEntry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListJpaRepository extends JpaRepository<WatchListEntry, Long> {
    Page<WatchListEntry> findAllByProfileId(Long profileId, Pageable pageable);
}
