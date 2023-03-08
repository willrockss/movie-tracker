package io.movietracker.core.infra.config;

public record TestPersonProperties(
        Long id,
        String login,
        String password,
        String name,
        Long selectedProfileId,
        Boolean isOwner
) {
}
