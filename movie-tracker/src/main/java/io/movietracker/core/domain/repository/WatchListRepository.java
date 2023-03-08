package io.movietracker.core.domain.repository;

import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.vo.ProfileId;
import io.movietracker.core.domain.vo.WatchListEntryId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WatchListRepository {
    WatchListEntry add(WatchListEntry entry);

    WatchListEntry update(WatchListEntry entry);

    boolean remove(WatchListEntry entry);

    @SuppressWarnings("unused")
    Optional<WatchListEntry> findById(WatchListEntryId id);

    Page<WatchListEntry> findAllByProfileId(ProfileId userProfile, Pageable pageable);
}
