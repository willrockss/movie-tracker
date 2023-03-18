package io.movietracker.core.infra.jpa.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;

import java.util.Map;

public class MapToStringConverter implements AttributeConverter<Map, String> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Map attribute) {
        if (attribute == null) return null;
        return MAPPER.writeValueAsString(attribute);
    }

    @SneakyThrows
    @Override
    public Map convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return MAPPER.readValue(dbData, Map.class);
    }
}
