package com.coviddata.solution;

import com.coviddata.solution.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SolutionApplication {

	@Autowired
	private CovidDataService service;

	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void updateData(){
		service.updateData();
	}
}
