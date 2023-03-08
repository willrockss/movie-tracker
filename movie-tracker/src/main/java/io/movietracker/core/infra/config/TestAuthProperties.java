package io.movietracker.core.infra.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;



@ConfigurationProperties(prefix = "test-auth")
@Data
@Component
public class TestAuthProperties {
    private boolean testAuthEnabled;
    private List<TestPersonProperties> persons;
}
