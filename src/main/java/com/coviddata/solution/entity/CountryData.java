package com.coviddata.solution.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CountryData {

    @Id
    @JsonIgnore
    private String countryCode;

    private String countryName;

    private String slug;

    private Long newConfirmed;

    private Long totalConfirmed;

    private Long newDeaths;

    private Long totalDeaths;

    private Long newRecovered;

    private Long totalRecovered;

    private Instant date;
}

