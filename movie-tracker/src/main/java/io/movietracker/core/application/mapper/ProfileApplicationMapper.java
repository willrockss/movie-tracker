package io.movietracker.core.application.mapper;

import io.movietracker.core.domain.vo.ProfileId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public
interface ProfileApplicationMapper {

    default Long map(ProfileId id) {
        return id.value();
    }

    @Mapping(target = "value", source = "id")
    ProfileId map(Long id);
}
