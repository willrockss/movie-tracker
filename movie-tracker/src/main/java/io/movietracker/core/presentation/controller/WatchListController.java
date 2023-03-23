package io.movietracker.core.presentation.controller;

import io.movietracker.core.application.request.GetWatchListEntriesRequest;
import io.movietracker.core.application.usecase.AddMovieToWatchListHandler;
import io.movietracker.core.application.usecase.GetWatchListEntriesHandler;
import io.movietracker.core.presentation.dto.WatchListEntry;
import io.movietracker.core.presentation.mapper.WatchListEntryPresentationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/watch-list-entry")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class WatchListController {

    private final GetWatchListEntriesHandler getWatchListEntriesHandler;
    private final AddMovieToWatchListHandler addMovieToWatchListHandler;

    private final WatchListEntryPresentationMapper mapper;

    @GetMapping
    public Page<WatchListEntry> getToWatchList() {
        var response = getWatchListEntriesHandler.handle(new GetWatchListEntriesRequest());
        return response
                .page()
                .map(it -> mapper.map(it, response.videoContentMap().get(it.getVideoId())));
    }

    @PostMapping
    public WatchListEntry addEntry(@RequestBody WatchListEntry entry) {
        var resp = addMovieToWatchListHandler.handle(mapper.toRequest(entry));
        return mapper.responseToDto(resp);
    }
}
