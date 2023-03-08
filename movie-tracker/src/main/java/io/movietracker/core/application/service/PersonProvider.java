package io.movietracker.core.application.service;

import io.movietracker.core.domain.entity.Person;
import org.springframework.security.access.AccessDeniedException;

import java.util.Optional;

public interface PersonProvider {
    default Person getCurrent() {
        return getCurrentOptional().orElseThrow(() -> new AccessDeniedException("You need to log in"));
    }

    Optional<Person> getCurrentOptional();
}
