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
        return getWatchListEntriesHandler
                .handle(new GetWatchListEntriesRequest())
                .page()
                .map(mapper::map);
    }

    @PostMapping
    public WatchListEntry addEntry(@RequestBody WatchListEntry entry) {
        var resp = addMovieToWatchListHandler.handle(mapper.toRequest(entry));
        return mapper.responseToDto(resp);
    }
}
