package io.movietracker.core.presentation.dto;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private String name;
    private Long selectedProfileId;
}
