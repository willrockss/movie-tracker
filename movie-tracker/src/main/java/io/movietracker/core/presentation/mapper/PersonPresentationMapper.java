package io.movietracker.core.presentation.mapper;

import io.movietracker.core.application.mapper.PersonApplicationMapper;
import io.movietracker.core.application.mapper.ProfileApplicationMapper;
import io.movietracker.core.presentation.dto.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        PersonApplicationMapper.class,
        ProfileApplicationMapper.class,
})
public interface PersonPresentationMapper {
    Person map(io.movietracker.core.domain.entity.Person personEntity);

}
