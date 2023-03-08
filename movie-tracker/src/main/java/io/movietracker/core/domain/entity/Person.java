package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Entity which represents Person who watches movies and series
 */
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter
    private final PersonId id;

    // TODO set up `isOwner` property during selecting profile
    @Getter
    @Setter
    private ProfileId selectedProfileId;

    @Getter
    @Setter
    private String name;

    @Getter
    private Boolean isOwner;
}
