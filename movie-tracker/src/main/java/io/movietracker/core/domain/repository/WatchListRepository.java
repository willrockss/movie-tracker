package io.movietracker.core.domain.repository;

import io.movietracker.core.domain.entity.WatchListEntry;

public interface WatchListRepository {
    WatchListEntry add(WatchListEntry entry);

    WatchListRepository update(WatchListEntry entry);

    boolean remove(WatchListEntry entry);
}
