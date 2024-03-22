package com.scw.sports.carnival.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scw.sports.carnival.config.AllGamesConfig;
import com.scw.sports.carnival.config.GamesAmountConfig;
import com.scw.sports.carnival.model.RegistrationDetails;
import com.scw.sports.carnival.model.RegistrationRequest;
import com.scw.sports.carnival.model.RegistrationResponse;
import com.scw.sports.carnival.model.RegistrationView;
import com.scw.sports.carnival.model.Sports;
import com.scw.sports.carnival.services.SportsRegistrationServicesImpl;

import jakarta.validation.Valid;

@Controller
public class SportsRegistartionController {

	@Autowired
	private SportsRegistrationServicesImpl sportsRegistrationServicesImpl;

	@Autowired
	private AllGamesConfig gamesConfig;

	@Autowired
	private GamesAmountConfig amountConfig;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}

	@GetMapping("/addregistration")
	public String addRegistration(Model model) {
		RegistrationDetails registrationDetails = new RegistrationDetails();
		model.addAttribute("registrationDetails", registrationDetails);

		populateAllSports(model);
		return "newregistration";
	}
	
	@GetMapping("/saveregistration")
	public String saveRegistrationReload(Model model) {
		RegistrationDetails registrationDetails = new RegistrationDetails();
		model.addAttribute("registrationDetails", registrationDetails);

		populateAllSports(model);
		return "newregistration";
	}

	@PostMapping("/saveregistration")
	public String saveRegistration(
			@Valid @ModelAttribute("registrationDetails") RegistrationDetails registrationDetails, BindingResult result,
			Model model) {

		if (result.hasFieldErrors()) {
			System.out.println("Yes form has errors");
			populateAllSports(model);
			return "newregistration";
		}

		System.out.println("form does not have any errors");

		List<Sports> registeredGames = new ArrayList();

		// Convert the ids into the game names
		for (String gameID : registrationDetails.getRegisteredSports()) {
			Sports sports = new Sports();
			sports.setId(gameID);
			sports.setDescription(gamesConfig.getGames().get(gameID));
			registeredGames.add(sports);
		}

		registrationDetails.setRegisteredGames(registeredGames);
		registrationDetails.setAmount(calculateAmount(registrationDetails.getRegisteredSports()));

		ResponseEntity<RegistrationResponse> response = sportsRegistrationServicesImpl.save(registrationDetails);

		if (!HttpStatus.OK.equals(response.getStatusCode())) {
			System.out.println("The service has a failure");
			model.addAttribute("serviceErrorMessage", response.getBody().getMessage());
			populateAllSports(model);
			return "newregistration";
		} else {
			System.out.println("Service is successful");
		}
		return "confirmation";
	}


	@GetMapping("/viewregistration")
	public String viewRegistration(Model model) {
		RegistrationView registartionView = new RegistrationView();
		model.addAttribute("registartionView", registartionView);
		return "viewregistration";
	}
	
	@GetMapping("/fetchregistration")
	public String fetchRegistrationReload(Model model) {
		RegistrationView registartionView = new RegistrationView();
		model.addAttribute("registartionView", registartionView);
		return "viewregistration";
	}

	@PostMapping("/fetchregistration")
	public String fetchRegistration(
			@Valid @ModelAttribute("registartionView") RegistrationView registartionView, BindingResult result,
			Model model) {

		System.out.println("Request coming here");
		
		if (result.hasFieldErrors()) {
			return "viewregistration";
		}

		ResponseEntity<RegistrationResponse> response = sportsRegistrationServicesImpl
				.getUserData(registartionView.getPhoneNumber());

		if (!HttpStatus.OK.equals(response.getStatusCode())) {
			System.out.println("The service has a failure");
			model.addAttribute("serviceErrorMessage", response.getBody().getMessage());
			return "viewregistration";
		} else {
			System.out.println("Service is successful");
		}
		
		RegistrationRequest userDetails = response.getBody().getRequestDetails();
		model.addAttribute("userDetails", userDetails);
		
		List<String> games = new ArrayList<>();
		
		for (String gameID : userDetails.getGames()) {
			games.add(gamesConfig.getGames().get(gameID));
		}
		model.addAttribute("games", games);		
		return "viewregistrationdetails";
	}


	private void populateAllSports(Model model) {
		List<Sports> allsports = new ArrayList<>();

		for (Map.Entry<String, String> entry : gamesConfig.getGames().entrySet()) {
			Sports sports = new Sports();
			sports.setId(entry.getKey());
			sports.setDescription(entry.getValue());
			allsports.add(sports);
		}
		model.addAttribute("allsports", allsports);

	}

	private Integer calculateAmount(String[] sports) {
		int totalAmount = 0;
		for (String gameKey : sports) {
			totalAmount = totalAmount + Integer.parseInt(amountConfig.getGameamount().get(gameKey));
		}
		System.out.println("The total regd amount is ::: " + totalAmount);
		return totalAmount;
	}

}