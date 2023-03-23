package io.movietracker.core.presentation.mapper;


import io.movietracker.core.application.mapper.CommonApplicationMapper;
import io.movietracker.core.application.mapper.VideoApplicationMapper;
import io.movietracker.core.application.mapper.WatchListEntryApplicationMapper;
import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import io.movietracker.core.domain.entity.VideoContent;
import io.movietracker.core.domain.vo.FullTitle;
import io.movietracker.core.presentation.dto.WatchListEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        CommonApplicationMapper.class,
        WatchListEntryApplicationMapper.class,
        VideoApplicationMapper.class,
})
public interface WatchListEntryPresentationMapper {
    AddMovieToWatchListRequest toRequest(WatchListEntry srcDto);

    default String map(FullTitle title) {
        return title.toString();
    }

    @Mapping(target = ".", source = "srcResponse.createdEntry")
    @Mapping(target = "fullTitle", source = "srcResponse.videoContent.fullTitle")
    WatchListEntry responseToDto(AddMovieToWatchListResponse srcResponse);

    @Mapping(target = "id", source = "watchListEntryEntity.id")
    @Mapping(target = "fullTitle", source = "videoContent.fullTitle")
    WatchListEntry map(
            io.movietracker.core.domain.entity.WatchListEntry watchListEntryEntity,
            VideoContent videoContent
    );
}
