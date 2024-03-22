package com.scw.sports.carnival.services;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scw.sports.carnival.model.RegistrationDetails;
import com.scw.sports.carnival.model.RegistrationRequest;
import com.scw.sports.carnival.model.RegistrationResponse;

import jakarta.validation.constraints.AssertFalse.List;

@Service
public class SportsRegistrationServicesImpl implements SportsRegistrationServices {

	@Override
	public ResponseEntity<RegistrationResponse> save(RegistrationDetails registrationDetails) {
		registrationDetails.getRegisteredGames();
		System.out.println("Lets debug if all values are getting populated");
		System.out.println(registrationDetails.toString());

		/*
		 * return
		 * ResponseEntity.status(HttpStatus.FORBIDDEN).body(RegistrationResponse.builder
		 * ().message("User " +
		 * "already registered").details(registrationDetails).build());
		 */		
		return ResponseEntity.ok().body(RegistrationResponse.builder().message("User " +
                "registered successfully").details(registrationDetails).build());
		
	}

	@Override
	public ResponseEntity<RegistrationResponse> getUserData(String phoneNumber) {
		java.util.List<String> games = Arrays.asList("3","4","13");
        return ResponseEntity.ok(RegistrationResponse
                .builder()
                .message("User registered successfully").
                requestDetails(RegistrationRequest.builder()
                        .amount(375)
                        .name("Vedatman Budhia")
                        .phoneNumber("9743063852")
                        .apartmentNumber("020604")
                        .games(games)
                        .transactionId("2121212x43443")
                        .build()).build());
	}

}
