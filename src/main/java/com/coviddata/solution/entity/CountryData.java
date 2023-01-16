package com.coviddata.solution.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryData extends AbstractEntity {

    @JsonProperty("ID")
    private String externalID;

    @JsonProperty("CountryCode")
    @Column(unique = true)
    private String countryCode;

    @JsonProperty("Country")
    private String countryName;

    @JsonProperty("Slug")
    private String slug;

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

