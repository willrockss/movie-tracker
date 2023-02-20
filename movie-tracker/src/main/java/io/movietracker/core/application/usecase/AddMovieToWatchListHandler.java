package io.movietracker.core.application.usecase;

import io.movietracker.core.application.mapper.WatchListEntryMapper;
import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.repository.WatchListRepository;
import io.movietracker.core.domain.vo.VideoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddMovieToWatchListHandler {
    private final PersonProvider personProvider;
    private final WatchListRepository watchListRepository;

    private final WatchListEntryMapper mapper;

    public AddMovieToWatchListResponse handle(AddMovieToWatchListRequest addMovieToWatchListRequest) {
        var currentPerson = personProvider.getCurrent();

        // TODO check video exists
        var videoId = new VideoId(addMovieToWatchListRequest.videoId());
        var initialEntity = WatchListEntry.builder()
                .videoId(videoId)
                .profileId(currentPerson.getSelectedProfileId())
                .personId(currentPerson.getId())
                .preComment(addMovieToWatchListRequest.preComment())
                .build();

        var savedEntity = watchListRepository.add(initialEntity);
        return mapper.toResponse(savedEntity);
    }
}
