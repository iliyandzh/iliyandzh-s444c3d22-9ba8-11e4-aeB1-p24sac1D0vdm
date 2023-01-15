package com.coviddata.solution.dto;


import com.coviddata.solution.entity.CountryData;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CovidData {

    private GlobalData globalData;

    private CountryData dataByCountry;
}
