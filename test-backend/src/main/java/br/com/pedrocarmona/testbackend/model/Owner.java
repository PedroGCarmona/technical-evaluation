package br.com.pedrocarmona.testbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("reputation")
    private Long reputation;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("accept_rate")
    private Long acceptRate;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("link")
    private String link;
}
