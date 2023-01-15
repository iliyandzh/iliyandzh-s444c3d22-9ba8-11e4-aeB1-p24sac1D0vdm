package com.coviddata.solution.service;

import com.coviddata.solution.dto.CovidData;
import com.coviddata.solution.entity.CountryData;
import com.coviddata.solution.dto.GlobalData;
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

    private final String COVID_API_URL = "https://api.covid19api.com/summary";
    private final String NEW_CONFIRMED = "NewConfirmed";
    private final String TOTAL_CONFIRMED = "TotalConfirmed";
    private final String NEW_DEATHS = "NewDeaths";
    private final String TOTAL_DEATHS = "TotalDeaths";
    private final String NEW_RECOVERED = "NewRecovered";
    private final String TOTAL_RECOVERED = "TotalRecovered";
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

            this.globalData =
                    GlobalData.builder()
                            .message(root.path("Message").textValue())
                            .newConfirmed(global.path(NEW_CONFIRMED).longValue())
                            .totalConfirmed(global.path(TOTAL_CONFIRMED).longValue())
                            .newDeaths(global.path(NEW_DEATHS).longValue())
                            .totalDeaths(global.path(TOTAL_DEATHS).longValue())
                            .newRecovered(global.path(NEW_RECOVERED).longValue())
                            .totalRecovered(global.path(TOTAL_RECOVERED).longValue())
                            .date(Instant.parse(global.path(DATE).textValue()))
                            .build();

            for (JsonNode countryNode : countries) {
                CountryData countryData = new CountryData();
                countryData.setCountryCode(countryNode.path("CountryCode").textValue());
                countryData.setCountryName(countryNode.path("Country").textValue());
                countryData.setSlug(countryNode.path("Slug").textValue());
                countryData.setNewConfirmed(countryNode.path(NEW_CONFIRMED).longValue());
                countryData.setTotalConfirmed(countryNode.path(TOTAL_CONFIRMED).longValue());
                countryData.setNewDeaths(countryNode.path(NEW_DEATHS).longValue());
                countryData.setTotalDeaths(countryNode.path(TOTAL_DEATHS).longValue());
                countryData.setNewRecovered(countryNode.path(NEW_RECOVERED).longValue());
                countryData.setTotalRecovered(countryNode.path(TOTAL_RECOVERED).longValue());
                countryData.setDate(Instant.parse(countryNode.path(DATE).asText()));
                countryDataRepository.save(countryData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public CovidData covidData(String countryCode) {
        val countryData = countryDataRepository.findById(countryCode).orElse(null);
        val globalData = this.globalData;
        return
          CovidData.builder()
          .dataByCountry(countryData)
          .globalData(globalData)
          .build();
    }

}
