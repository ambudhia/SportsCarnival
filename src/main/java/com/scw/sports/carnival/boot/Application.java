package com.scw.sports.carnival.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scw.sports.carnival.config.AllGamesConfig;
import com.scw.sports.carnival.controller.SportsRegistartionController;
import com.scw.sports.carnival.model.RegistrationDetails;
import com.scw.sports.carnival.services.SportsRegistrationServices;

@SpringBootApplication(scanBasePackageClasses = { SportsRegistartionController.class, RegistrationDetails.class,
		SportsRegistrationServices.class, AllGamesConfig.class })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
