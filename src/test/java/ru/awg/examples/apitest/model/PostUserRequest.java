package ru.awg.examples.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostUserRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("job")
    private String job;
}