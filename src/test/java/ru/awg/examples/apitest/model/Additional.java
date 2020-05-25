package ru.awg.examples.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("WeakerAccess")
public class Additional {
    @JsonProperty("company")
    private String company;
    @JsonProperty("text")
    private String text;
    @JsonProperty("url")
    private String url;
}