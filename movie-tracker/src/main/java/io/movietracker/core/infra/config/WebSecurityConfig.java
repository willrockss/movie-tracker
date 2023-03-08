package io.movietracker.core.infra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final TestAuthProperties testAuthProperties;

    @Bean
    @SuppressWarnings("unused")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        if (testAuthProperties.isTestAuthEnabled()) {
            http.httpBasic();
        } else {
            http.formLogin();
        }

        http.anonymous().disable();
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login*").permitAll()
                        .anyRequest().authenticated()
                );


        return http.build();
    }
}