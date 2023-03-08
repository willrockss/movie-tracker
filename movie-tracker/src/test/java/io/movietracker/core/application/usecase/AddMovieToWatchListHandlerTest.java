package io.movietracker.core.application.usecase;

import io.movietracker.core.application.mapper.WatchListEntryApplicationMapper;
import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.application.service.PersonProvider;
import io.movietracker.core.domain.entity.Person;
import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.repository.WatchListRepository;
import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import io.movietracker.core.domain.vo.WatchListEntryId;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mapstruct.factory.Mappers;
import org.mockito.stubbing.Answer;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddMovieToWatchListHandlerTest {

    private final PersonProvider personProvider = mock(PersonProvider.class);
    private final WatchListRepository watchListRepository = mock(WatchListRepository.class);

    private final WatchListEntryApplicationMapper mapper = Mappers.getMapper(WatchListEntryApplicationMapper.class);
    private final AddMovieToWatchListHandler sut = new AddMovieToWatchListHandler(
            personProvider,
            watchListRepository,
            mapper
    );

    @Test
    void should_fill_all_fields_properly_during_creation() {
        // given
        var currentPerson = new Person(new PersonId(1001L), new ProfileId(10L), "Bob", true);
        when(personProvider.getCurrent()).thenReturn(currentPerson);
        when(personProvider.getCurrentOptional()).thenReturn(Optional.of(currentPerson));

        Field wathListEntryIdField = ReflectionUtils.findFields(
                WatchListEntry.class,
                field -> field.getName().equalsIgnoreCase("id"),
                ReflectionUtils.HierarchyTraversalMode.TOP_DOWN
        ).get(0);
        wathListEntryIdField.setAccessible(true);

        when(watchListRepository.add(any())).then((Answer<WatchListEntry>) invocation -> {
            var entity = invocation.getArgument(0, WatchListEntry.class);
            wathListEntryIdField.set(entity, new WatchListEntryId(777L));
            return entity;
        });

        // when
        var req = new AddMovieToWatchListRequest("MOV-001", null);
        var resp = sut.handle(req);

        // then
        var createdEntry = resp.createdEntry();
        assertEquals(777, createdEntry.getId().value());
        assertNull(createdEntry.getPreComment());
        assertEquals("MOV-001", createdEntry.getVideoId().value());
    }
}
