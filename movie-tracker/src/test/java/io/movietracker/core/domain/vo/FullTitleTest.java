package io.movietracker.core.domain.vo;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FullTitleTest {

    @Test
    public void should_include_nameEn_when_present() {
        var title = FullTitle
                .builder()
                .nameLocal("Матрица")
                .nameEn(Optional.of("Matrix"))
                .year(1999)
                .build();
        assertEquals("Матрица (1999, Matrix)", title.toString());
    }

    @Test
    public void should_omit_nameEn_if_there_is_no_one() {
        var title = FullTitle
                .builder()
                .nameLocal("Иван Васильевич меняет профессию")
                .year(1973)
                .build();

        assertEquals("Иван Васильевич меняет профессию (1973)", title.toString());
    }

}