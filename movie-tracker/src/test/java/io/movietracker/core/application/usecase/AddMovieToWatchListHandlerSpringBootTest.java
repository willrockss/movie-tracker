package io.movietracker.core.application.usecase;

import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles({"test", "dev"})
@Sql("/data-h2.sql")
@SpringBootTest
class AddMovieToWatchListHandlerSpringBootTest {

    @Autowired
    AddMovieToWatchListHandler sut;

    @WithUserDetails(value = "bob")
    @Test
    public void success_path() {
        var request = new AddMovieToWatchListRequest(
                "MOV-001",
                "Recommended by Fred"
        );
        AddMovieToWatchListResponse resp = sut.handle(request);
        assertNotNull(resp);
        assertNotNull(resp.createdEntry());
        assertNotNull(resp.createdEntry().getId());
        assertNotNull(resp.createdEntry().getAddedAt());
        assertNotNull(resp.videoContent());
        assertNotNull(resp.videoContent().getFullTitle());
    }

}