package com.coviddata.solution.controller;

import com.coviddata.solution.dto.CovidData;
import com.coviddata.solution.service.CovidDataService;
import com.coviddata.solution.exception.validator.Capitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/country")
public class CovidDataController {

    @Autowired
    private CovidDataService service;

    @GetMapping("/{countryCode}")
    public CovidData getCountryStats(@PathVariable("countryCode") @Capitals String countryCode) {
        CovidData covidData = service.covidData(countryCode);
        return covidData;
    }
}
