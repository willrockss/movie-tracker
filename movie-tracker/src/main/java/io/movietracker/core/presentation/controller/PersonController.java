package io.movietracker.core.presentation.controller;

import io.movietracker.core.application.service.PersonProvider;
import io.movietracker.core.presentation.dto.Person;
import io.movietracker.core.presentation.mapper.PersonPresentationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonProvider personProvider;

    private final PersonPresentationMapper mapper;

    @GetMapping("/person/me")
    public Person getMe() {
        // TODO extract to use-case
        return personProvider.getCurrentOptional()
                .map(mapper::map)
                .orElse(null);
    }
}
