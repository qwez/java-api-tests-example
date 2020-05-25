package ru.awg.examples.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("WeakerAccess")
@Data
public class User {
    @JsonProperty("last_name")
    private String  lastName;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("avatar")
    private String  avatar;
    @JsonProperty("first_name")
    private String  firstName;
    @JsonProperty("email")
    private String  email;
}