package ru.awg.examples.apitest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetUsersResponse {
    @JsonProperty("per_page")
    private Integer    perPage;
    @JsonProperty("total")
    private Integer    total;
    @JsonProperty("ad")
    private Additional ad;
    @JsonProperty("data")
    private List<User> data;
    @JsonProperty("page")
    private Integer    page;
    @JsonProperty("total_pages")
    private Integer    totalPages;
}