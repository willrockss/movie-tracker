package io.movietracker.core.infra.jpa;

import io.movietracker.core.application.mapper.VideoApplicationMapper;
import io.movietracker.core.domain.entity.VideoContent;
import io.movietracker.core.domain.vo.FullTitle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = { VideoApplicationMapper.class })
public interface VideoContentJpaMapper {
    @Mapping(target = "id", source = "jpaEntity.videoId")
    @Mapping(target = "type", source = "jpaEntity.videoType")
    @Mapping(target = "fullTitle", source = "jpaEntity", qualifiedByName = "fullTitleFromJpa")
    VideoContent map(io.movietracker.core.infra.jpa.VideoContent jpaEntity);

    @Named("fullTitleFromJpa")
    default FullTitle fullTitleFromJpaEntity(io.movietracker.core.infra.jpa.VideoContent jpaEntity) {
        return FullTitle
                .builder()
                .nameLocal(jpaEntity.getLocalizedTitle())
                .nameEn(Optional.ofNullable(jpaEntity.getEnTitle()))
                .year(jpaEntity.getYear())
                .build();
    }
}
