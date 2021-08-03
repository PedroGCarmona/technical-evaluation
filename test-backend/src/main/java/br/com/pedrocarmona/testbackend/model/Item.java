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
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("is_answered")
    private Boolean isAnswered;
    @JsonProperty("view_count")
    private Long viewCount;
    @JsonProperty("accepted_answer_id")
    private Long acceptedAnswerId;
    @JsonProperty("answer_count")
    private Long answerCount;
    @JsonProperty("score")
    private Long score;
    @JsonProperty("last_activity_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDateTime lastActivityLocalDateTime;
    @JsonProperty("creation_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDateTime creationLocalDateTime;
    @JsonProperty("last_edit_date")
    @JsonDeserialize(using = TimestampDeserializer.class)
    private LocalDateTime lastEditLocalDateTime;
    @JsonProperty("question_id")
    private Long questionId;
    @JsonProperty("content_license")
    private String contentLicense;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
}
