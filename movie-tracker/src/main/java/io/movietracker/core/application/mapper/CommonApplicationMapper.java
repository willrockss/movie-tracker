package io.movietracker.core.application.mapper;

import org.mapstruct.Mapper;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface CommonApplicationMapper {
    default ZonedDateTime map(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) return null;
        return offsetDateTime.toZonedDateTime();
    }

    default OffsetDateTime map(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) return null;
        return zonedDateTime.toOffsetDateTime();
    }

}
