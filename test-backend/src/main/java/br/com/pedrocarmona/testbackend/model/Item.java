package br.com.pedrocarmona.testbackend.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.pedrocarmona.testbackend.utils.TimestampDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("creation_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDateTime creationLocalDateTime;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
}
