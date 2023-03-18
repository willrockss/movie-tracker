package io.movietracker.core.infra.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Sql("/data-h2.sql")
class VideoContentJpaRepositoryDataJpaTest {

    @Autowired
    private VideoContentJpaRepository sut;

    @Test
    public void should_exist() {
        var allMovies = sut.findAll();

        assertFalse(allMovies.isEmpty(), "Database is not prepared for test");
        assertTrue(allMovies.stream().filter(it -> "MOV-001".equals(it.getVideoId())).findFirst().isPresent(),
                "Required movie record is absent in the initial DB");
        assertTrue(sut.existsByVideoId("MOV-001"));
    }

    @Test
    public void unknown_video_should_not_exit() {
        assertFalse(sut.existsByVideoId("SOME_UNKNOWN_ID"));
    }
}