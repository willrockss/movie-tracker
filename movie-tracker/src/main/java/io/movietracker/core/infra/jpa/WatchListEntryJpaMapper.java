package io.movietracker.core.infra.jpa;

import io.movietracker.core.application.mapper.PersonApplicationMapper;
import io.movietracker.core.application.mapper.ProfileApplicationMapper;
import io.movietracker.core.application.mapper.VideoApplicationMapper;
import io.movietracker.core.application.mapper.WatchListEntryApplicationMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        CommonJpaMapper.class,
        ProfileApplicationMapper.class,
        WatchListEntryApplicationMapper.class,
        VideoApplicationMapper.class,
        PersonApplicationMapper.class,
})
public interface WatchListEntryJpaMapper {

    WatchListEntry toJpaEntity(io.movietracker.core.domain.entity.WatchListEntry srcDomainEntity);

    io.movietracker.core.domain.entity.WatchListEntry toDomainEntity(WatchListEntry srcJpaEntity);
}
