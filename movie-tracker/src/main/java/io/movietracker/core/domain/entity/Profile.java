package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import lombok.Getter;

import java.util.List;

@Getter
public class Profile {
    private ProfileId id;
    private String title;
    private PersonId owner;
    private List<PersonId> persons;
}
