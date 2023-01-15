package com.coviddata.solution.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalData {

    private String message;

    private Long newConfirmed;

    private Long totalConfirmed;

    private Long newDeaths;

    private Long totalDeaths;

    private Long newRecovered;

    private Long totalRecovered;

    private Instant date;
}
