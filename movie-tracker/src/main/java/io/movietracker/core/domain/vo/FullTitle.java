package io.movietracker.core.domain.vo;

import java.util.Optional;

public record FullTitle(
        String nameLocal,
        Optional<String> nameEn,
        Integer year
) {
}
