package com.coviddata.solution.service;

import com.coviddata.solution.dto.CovidData;
import com.coviddata.solution.entity.CountryData;
import com.coviddata.solution.dto.GlobalData;
import com.coviddata.solution.exception.CountriesNotPresentException;
import com.coviddata.solution.exception.CountryCodeNotFoundException;
import com.coviddata.solution.repository.CountryDataRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;

@Service
public class CovidDataService {

    @Autowired
    private CountryDataRepository countryDataRepository;

    private GlobalData globalData;
    private String message;

    private final String COVID_API_URL = "https://api.covid19api.com/summary";
    private final String DATE = "Date";


    public void updateData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(COVID_API_URL).build();

        try {
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonData);
            JsonNode countries = root.path("Countries");
            JsonNode global = root.path("Global");

            this.message = root.path("Message").textValue();
            this.globalData = objectMapper.treeToValue(global, GlobalData.class);
            this.globalData.setDate(Instant.parse(global.path(DATE).textValue()));

            if(countries.toString().isBlank()){
                throw new CountriesNotPresentException();
            }

            for (JsonNode countryNode : countries) {
                CountryData countryData = objectMapper.treeToValue(countryNode, CountryData.class);
                countryData.setDate(Instant.parse(countryNode.path(DATE).asText()));
                countryDataRepository.save(countryData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public CovidData covidData(String countryCode) {
        val countryData = countryDataRepository.findByCountryCode(countryCode);
        if(countryData == null){
            throw new CountryCodeNotFoundException();
        }
        val globalData = this.globalData;
        return
          CovidData
          .builder()
          .message(this.message)
          .dataByCountry(countryData)
          .globalData(globalData)
          .build();
    }

}
