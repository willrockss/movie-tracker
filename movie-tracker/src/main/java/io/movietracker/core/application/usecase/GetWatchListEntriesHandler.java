package io.movietracker.core.application.usecase;

import io.movietracker.core.application.request.GetWatchListEntriesRequest;
import io.movietracker.core.application.response.GetWatchListEntriesResponse;
import io.movietracker.core.application.service.PersonProvider;
import io.movietracker.core.domain.repository.WatchListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNullElse;

@RequiredArgsConstructor
@Component
public class GetWatchListEntriesHandler {

    public static final int DEFAULT_PAGE_SIZE = 1000;
    private final PersonProvider personProvider;
    private final WatchListRepository watchListRepository;

    public GetWatchListEntriesResponse handle(GetWatchListEntriesRequest request) {
        var currentPerson = personProvider.getCurrent();
        var pageable = PageRequest.of(
                requireNonNullElse(request.page(), 0),
                requireNonNullElse(request.size(), DEFAULT_PAGE_SIZE)
        );
        var page = watchListRepository.findAllByProfileId(currentPerson.getSelectedProfileId(), pageable);
        return new GetWatchListEntriesResponse(page);
    }
}
