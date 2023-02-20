package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter
    private final PersonId id;
    @Getter
    @Setter
    private ProfileId selectedProfileId;
}
