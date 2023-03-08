package io.movietracker.core.infra.config;

import io.movietracker.core.infra.service.InMemoryUserDetailsManagerDecorator;
import io.movietracker.core.infra.service.PersonToUserDetailsAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@ConditionalOnProperty(value = "test-auth.test-auth-enabled", havingValue = "true")
@RequiredArgsConstructor
@Configuration
public class InMemoryUserDetailsManagerBeanConfig {

    private final TestAuthProperties testAuthProperties;

    @Bean
    @SuppressWarnings("unused")
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        if (!testAuthProperties.isTestAuthEnabled()
                || testAuthProperties.getPersons() == null
                || testAuthProperties.getPersons().isEmpty()
        ) {
            return new InMemoryUserDetailsManager();
        }

        List<PersonToUserDetailsAdapter> userDetails = testAuthProperties
                .getPersons()
                .stream()
                .map(PersonToUserDetailsAdapter::new)
                .toList();

        return new InMemoryUserDetailsManagerDecorator(userDetails);
    }

}

