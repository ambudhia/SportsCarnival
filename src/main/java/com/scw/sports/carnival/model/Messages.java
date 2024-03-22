package com.scw.sports.carnival.model;

public interface Messages {
    String PHONE_NUMBER_VALIDATION = "Phone Number should be 10 digits";
    String PHONE_NUMBER_CANNOT_BE_BLANK = "Phone number cannot be blank";
    String PHONE_NUMBER_CHECK = "Phone number should contain only digits";
    String NAME_NOT_BLANK = "Name cannot be blank";
    String NAME_LENGTH = "Name should be at least 3 characters long";
    String NAME_ALPHABETS = "Name should contain only alphabets";
    String APARTMENT_NUMBER_NOT_BLANK = "Apartment number cannot be blank";
    String APARTMENT_NUMBER_LENGTH = "Apartment number should be 6 characters long";
    String APARTMENT_NUMBER_DIGITS = "Apartment number should contain only digits";
    String TRANSACTION_ID_NOT_BLANK = "Transaction ID cannot be blank";
    String GAMES_NOT_BLANK = "Games cannot be blank";
    String AMOUNT_MIN = "Amount should be at least 100";
    String AMOUNT_MAX = "Amount should be at most 1000";
    String USERNAME_LENGTH = "Username should be at least 3 characters long";
    String USERNAME_ALPHABETS = "Username should contain only alphabets";
    String PASSWORD_LENGTH = "Password should be at least 3 characters long";
    String PASSWORD_ALPHABETS = "Password should contain only alphabets and digits";
    String USER_ALREADY_EXISTS = "User already exists";
    String USER_REGISTERED = "User registered";
    String USER_NOT_FOUND = "User not found";
    String INVALID_PASSWORD = "Invalid password";
    String USER_SIGNED_IN = "User signed in successfully";
    String USER_SIGNED_OUT = "User signed out successfully";
}
