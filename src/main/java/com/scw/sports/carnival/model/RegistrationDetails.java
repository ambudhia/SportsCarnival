package com.scw.sports.carnival.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class RegistrationDetails {

	
	@NotEmpty(message = "The name can not be empty")
	private String name;
	
	@NotEmpty(message = "The email can not be empty")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid")
	private String email;
	
	@NotEmpty(message = "The Apt Number can not be empty")
	private String aptNo;
	
	@NotEmpty(message = "The Phone Number can not be empty")
	@Pattern(regexp = "^\\d{10}$", message="Mobile Number format is invalid")
	private String phoneNumber;
	private List<Sports> registeredGames;
	
	@NotEmpty(message = "You must select at least one sports to register")
	private String[] registeredSports;
	
	private String txnid;
	private MultipartFile transactionfile;
	
	private List<String> games;
	private Integer amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAptNo() {
		return aptNo;
	}

	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getAptNo() + "-");
		builder.append(getName() + "-");
		builder.append(getEmail());
		return builder.toString();
	}

	public String[] getRegisteredSports() {
		return registeredSports;
	}

	public void setRegisteredSports(String[] registeredSports) {
		this.registeredSports = registeredSports;
	}

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public MultipartFile getTransactionfile() {
		return transactionfile;
	}

	public void setTransactionfile(MultipartFile transactionfile) {
		this.transactionfile = transactionfile;
	}

	public List<Sports> getRegisteredGames() {
		return registeredGames;
	}

	public void setRegisteredGames(List<Sports> registeredGames) {
		this.registeredGames = registeredGames;
	}

	public List<String> getGames() {
		return games;
	}

	public void setGames(List<String> games) {
		this.games = games;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
