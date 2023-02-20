package io.movietracker.core.application.usecase;

import io.movietracker.core.domain.entity.Person;

public interface PersonProvider {
    Person getCurrent();
}
