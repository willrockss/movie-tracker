package io.movietracker.core.application.mapper;

import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import io.movietracker.core.domain.vo.WatchListEntryId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WatchListEntryApplicationMapper {

    default Long map(WatchListEntryId wleId) {
        if (wleId == null) return null;
        return wleId.value();
    }

    @Mapping(target = "value", source = "id")
    WatchListEntryId map(Long id);

    @Mapping(target = "createdEntry", source = "srcEntity")
    AddMovieToWatchListResponse toResponse(WatchListEntry srcEntity);
}
