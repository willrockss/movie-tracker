package io.movietracker.core.domain.vo;

import lombok.Builder;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Builder
public record FullTitle(
        String nameLocal,
        Optional<String> nameEn,
        Integer year
) {
    public FullTitle (String nameLocal, @Nullable Optional<String> nameEn, Integer year) {
        this.nameLocal = nameLocal;
        this.nameEn = nameEn != null ? nameEn : Optional.empty();
        this.year = year;
    }

    public FullTitle(String nameLocal, Integer year) {
        this(nameLocal, Optional.empty(), year);
    }

    public FullTitle(String nameLocal, String nameEn, Integer year) {
        this(nameLocal, Optional.ofNullable(nameEn), year);
    }

    @Override
    public String toString() {
        return String.format("%s (%d%s)", nameLocal, year, nameEn.map(it -> ", " + it).orElse(""));
    }
}
