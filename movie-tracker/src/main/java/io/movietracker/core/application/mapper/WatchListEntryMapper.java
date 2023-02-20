package io.movietracker.core.application.mapper;

import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WatchListEntryMapper {
    @Mapping(target = "videoId", source = "srcEntity.videoId.id")
    AddMovieToWatchListResponse toResponse(WatchListEntry srcEntity);
}
