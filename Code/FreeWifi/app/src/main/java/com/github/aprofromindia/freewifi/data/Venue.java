package com.github.aprofromindia.freewifi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"id", "name", "address"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {
    private long id;
    private String name;
    private String description;
    private Category category;
    private String address;
    private double latitude;
    private double longitude;

    private enum Category {
        @JsonProperty("bar")
        Bar,
        @JsonProperty("restaurant")
        Restaurant,
        @JsonProperty("coworking_space")
        CoWorkingSpace
    }
}
