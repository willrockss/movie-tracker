package io.movietracker.core.infra.jpa;

import io.movietracker.core.infra.jpa.converter.MapToStringConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity
@Getter
@Setter
public class VideoContent {
    @Id
    String videoId;
    @Column
    String videoType;
    @Column
    String localizedTitle;
    @Column
    String enTitle;
    @Column(name = "\"year\"")
    Integer year;
    @Column(columnDefinition = "TEXT")
    @Convert(converter = MapToStringConverter.class)
    Map<String, Object> info;
}
