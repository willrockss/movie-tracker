package io.movietracker.core.presentation.mapper;


import io.movietracker.core.application.mapper.CommonApplicationMapper;
import io.movietracker.core.application.mapper.VideoApplicationMapper;
import io.movietracker.core.application.mapper.WatchListEntryApplicationMapper;
import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.presentation.dto.WatchListEntry;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        CommonApplicationMapper.class,
        WatchListEntryApplicationMapper.class,
        VideoApplicationMapper.class,
})
public interface WatchListEntryPresentationMapper {
    AddMovieToWatchListRequest toRequest(WatchListEntry srcDto);

    @Mapping(target = ".", source = "srcResponse.createdEntry")
    WatchListEntry responseToDto(AddMovieToWatchListResponse srcResponse);

    WatchListEntry map(io.movietracker.core.domain.entity.WatchListEntry watchListEntryEntity);
}
