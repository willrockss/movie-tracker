package io.movietracker.core.infra.service;

import io.movietracker.core.domain.entity.Person;
import io.movietracker.core.domain.vo.PersonId;
import io.movietracker.core.domain.vo.ProfileId;
import io.movietracker.core.infra.config.TestPersonProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PersonToUserDetailsAdapter extends Person implements UserDetails {

        private final UserDetails userDetails;

        public PersonToUserDetailsAdapter(TestPersonProperties testPersonProperties) {
                super(
                        new PersonId(testPersonProperties.id()),
                        new ProfileId(testPersonProperties.selectedProfileId()),
                        testPersonProperties.name(),
                        testPersonProperties.isOwner()
                );
                this.userDetails = User.withDefaultPasswordEncoder()
                        .username(testPersonProperties.login())
                        .password(testPersonProperties.password())
                        .roles()
                        .build();

        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return userDetails.getAuthorities();
        }

        @Override
        public String getPassword() {
                return userDetails.getPassword();
        }

        @Override
        public String getUsername() {
                return userDetails.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
                return userDetails.isAccountNonExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
                return userDetails.isAccountNonLocked();
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return userDetails.isCredentialsNonExpired();
        }

        @Override
        public boolean isEnabled() {
                return userDetails.isEnabled();
        }
}
