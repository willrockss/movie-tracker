package io.movietracker.core.domain.entity;

import io.movietracker.core.domain.vo.ProfileId;
import lombok.Getter;

@Getter
public class Profile {
    private ProfileId id;
    private String title;
}
