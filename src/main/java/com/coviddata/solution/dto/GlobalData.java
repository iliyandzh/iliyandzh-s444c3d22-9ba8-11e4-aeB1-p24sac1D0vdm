package com.coviddata.solution.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalData{

    @JsonProperty("NewConfirmed")
    private Long newConfirmed;

    @JsonProperty("TotalConfirmed")
    private Long totalConfirmed;

    @JsonProperty("NewDeaths")
    private Long newDeaths;

    @JsonProperty("TotalDeaths")
    private Long totalDeaths;

    @JsonProperty("NewRecovered")
    private Long newRecovered;

    @JsonProperty("TotalRecovered")
    private Long totalRecovered;

    private Instant date;
}

