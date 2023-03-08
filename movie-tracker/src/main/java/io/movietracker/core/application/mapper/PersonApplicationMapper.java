package io.movietracker.core.application.mapper;

import io.movietracker.core.domain.vo.PersonId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonApplicationMapper {

    default Long map(PersonId personId) {
        return personId.value();
    }

    default PersonId map(Long personId) {
        return new PersonId(personId);
    }
}
