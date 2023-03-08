package io.movietracker.core.infra.jpa;

import org.mapstruct.Mapper;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface CommonJpaMapper {

    default OffsetDateTime map(ZonedDateTime value) {
        if(value == null) return null;
        return value.toOffsetDateTime();
    }

    default ZonedDateTime map(OffsetDateTime value) {
        if (value == null) return null;
        return value.toZonedDateTime();
    }
}
