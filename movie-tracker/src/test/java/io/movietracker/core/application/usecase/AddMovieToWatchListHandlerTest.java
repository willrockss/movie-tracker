package io.movietracker.core.application.usecase;

import io.movietracker.core.application.mapper.WatchListEntryMapper;
import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.domain.entity.Person;
import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.repository.WatchListRepository;
import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mapstruct.factory.Mappers;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddMovieToWatchListHandlerTest {

    private final PersonProvider personProvider = mock(PersonProvider.class);
    private final WatchListRepository watchListRepository = mock(WatchListRepository.class);

    private final WatchListEntryMapper mapper = Mappers.getMapper(WatchListEntryMapper.class);
    private final AddMovieToWatchListHandler sut = new AddMovieToWatchListHandler(
            personProvider,
            watchListRepository,
            mapper
    );

    @Test
    void should_fill_all_fields_properly_during_creation() {
        // given
        var currentPerson = new Person(new PersonId(1001L), new ProfileId(10L));
        when(personProvider.getCurrent()).thenReturn(currentPerson);

        Field wathListEntryIdField = ReflectionUtils.findFields(
                WatchListEntry.class,
                field -> field.getName().equalsIgnoreCase("id"),
                ReflectionUtils.HierarchyTraversalMode.TOP_DOWN
        ).get(0);
        wathListEntryIdField.setAccessible(true);

        when(watchListRepository.add(any())).then((Answer<WatchListEntry>) invocation -> {
            var entity = invocation.getArgument(0, WatchListEntry.class);
            wathListEntryIdField.set(entity, 777L);
            return entity;
        });

        // when
        var req = new AddMovieToWatchListRequest("MOV-001", null);
        var resp = sut.handle(req);

        // then
        assertEquals(777, resp.id());
        assertNull(resp.preComment());
        assertEquals("MOV-001", req.videoId());
    }
}
