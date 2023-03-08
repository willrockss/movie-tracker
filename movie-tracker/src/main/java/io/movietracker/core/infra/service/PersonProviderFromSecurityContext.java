package io.movietracker.core.infra.service;

import io.movietracker.core.application.service.PersonProvider;
import io.movietracker.core.domain.entity.Person;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@SuppressWarnings("unused")
public class PersonProviderFromSecurityContext implements PersonProvider {
    @Override
    public Optional<Person> getCurrentOptional() {
        var context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication != null) {
            var person = authentication.getPrincipal();
            if (person instanceof Person) {
                return Optional.of((Person) person);
            }
        }
        return Optional.empty();
    }
}
