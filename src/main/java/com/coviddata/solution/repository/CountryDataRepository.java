package com.coviddata.solution.repository;

import com.coviddata.solution.entity.CountryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDataRepository extends JpaRepository<CountryData, String> {
    CountryData findByCountryCode(String countryCode);
}
