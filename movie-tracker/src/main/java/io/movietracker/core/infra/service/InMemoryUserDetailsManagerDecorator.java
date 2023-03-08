package io.movietracker.core.infra.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collection;
import java.util.List;

public class InMemoryUserDetailsManagerDecorator extends InMemoryUserDetailsManager {

    private List<PersonToUserDetailsAdapter> personList;

    @SuppressWarnings("unused")
    public InMemoryUserDetailsManagerDecorator() {
        super();
    }

    public InMemoryUserDetailsManagerDecorator(List<? extends UserDetails> personUserDetails) {
        super((Collection<UserDetails>) personUserDetails);
        personList = (List<PersonToUserDetailsAdapter>) personUserDetails;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personList
                .stream()
                .filter(it -> it.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
