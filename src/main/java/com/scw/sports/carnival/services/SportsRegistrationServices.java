package com.scw.sports.carnival.services;

import org.springframework.http.ResponseEntity;

import com.scw.sports.carnival.model.RegistrationDetails;
import com.scw.sports.carnival.model.RegistrationResponse;

public interface SportsRegistrationServices {

	ResponseEntity<RegistrationResponse> save(RegistrationDetails registrationDetails);
	ResponseEntity<RegistrationResponse> getUserData(String phoneNumber);

}
