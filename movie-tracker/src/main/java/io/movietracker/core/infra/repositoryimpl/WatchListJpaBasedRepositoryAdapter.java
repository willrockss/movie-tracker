package io.movietracker.core.infra.repositoryimpl;

import io.movietracker.core.domain.entity.WatchListEntry;
import io.movietracker.core.domain.repository.WatchListRepository;
import io.movietracker.core.domain.vo.ProfileId;
import io.movietracker.core.domain.vo.WatchListEntryId;
import io.movietracker.core.infra.jpa.WatchListEntryJpaMapper;
import io.movietracker.core.infra.jpa.repository.WatchListJpaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class WatchListJpaBasedRepositoryAdapter implements WatchListRepository {

    private final WatchListJpaRepository watchListJpaRepository;
    private final WatchListEntryJpaMapper jpaMapper;

    @Override
    public WatchListEntry add(WatchListEntry entry) {
        var jpaEntity = jpaMapper.toJpaEntity(entry);
        var savedJpaEntity = watchListJpaRepository.save(jpaEntity);
        return jpaMapper.toDomainEntity(savedJpaEntity);
    }

    @Override
    public WatchListEntry update(WatchListEntry entry) {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(WatchListEntry entry) {
        throw new NotImplementedException();
    }

    public Optional<WatchListEntry> findById(WatchListEntryId id) {throw new NotImplementedException();}

    @Override
    public Page<WatchListEntry> findAllByProfileId(ProfileId userProfile, Pageable pageable) {
        var jpaPageResp = watchListJpaRepository.findAllByProfileId(userProfile.value(), pageable);
        return jpaPageResp.map(jpaMapper::toDomainEntity);
    }
}
