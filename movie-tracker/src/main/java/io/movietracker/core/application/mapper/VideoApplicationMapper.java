package io.movietracker.core.application.mapper;

import io.movietracker.core.domain.vo.VideoId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public
interface VideoApplicationMapper {

    default String map(VideoId id) {
        return id.value();
    }

    @Mapping(target = "value", source = "id")
    VideoId map(String id);
}
