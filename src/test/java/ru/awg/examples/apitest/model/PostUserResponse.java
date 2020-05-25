package ru.awg.examples.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostUserResponse {
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("job")
    private String job;
}