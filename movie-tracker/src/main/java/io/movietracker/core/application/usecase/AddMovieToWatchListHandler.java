package io.movietracker.core.application.usecase;

import io.movietracker.core.application.mapper.WatchListEntryApplicationMapper;
import io.movietracker.core.application.request.AddMovieToWatchListRequest;
import io.movietracker.core.application.response.AddMovieToWatchListResponse;
import io.movietracker.core.application.service.PersonProvider;
import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.error.VideoIsNotPresentError;
import io.movietracker.core.domain.repository.VideoContentRepository;
import io.movietracker.core.domain.repository.WatchListRepository;
import io.movietracker.core.domain.vo.VideoId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class AddMovieToWatchListHandler {
    private final PersonProvider personProvider;
    private final WatchListRepository watchListRepository;

    private final VideoContentRepository videoContentRepository;

    private final WatchListEntryApplicationMapper mapper;

    public AddMovieToWatchListResponse handle(AddMovieToWatchListRequest addMovieToWatchListRequest) {
        var currentPerson = personProvider.getCurrent();

        var videoId = new VideoId(addMovieToWatchListRequest.videoId());
        var videoContent = videoContentRepository
                .findByVideoId(videoId)
                .orElseThrow(() -> new VideoIsNotPresentError(videoId));

        var initialEntity = WatchListEntry.builder()
                .videoId(videoId)
                .profileId(currentPerson.getSelectedProfileId())
                .updatedBy(currentPerson.getId())
                .preComment(addMovieToWatchListRequest.preComment())
                .addedAt(ZonedDateTime.now()) // TODO move this logic into Entity
                .build();

        var savedEntity = watchListRepository.add(initialEntity);
        return mapper.toResponse(savedEntity, videoContent);
    }
}
