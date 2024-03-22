package com.scw.sports.carnival.model;


import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class RegistrationRequest {
    @NotNull(message = Messages.NAME_NOT_BLANK)
    @Size(min = 3, message = Messages.NAME_LENGTH)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = Messages.NAME_ALPHABETS)
    private String name;
    @NotNull(message = Messages.PHONE_NUMBER_CANNOT_BE_BLANK)
    @Size(min = 10, max = 10, message = Messages.PHONE_NUMBER_VALIDATION)
    @Pattern(regexp = "[0-9]+", message = Messages.PHONE_NUMBER_CHECK)
    private String phoneNumber;
    @NotNull(message = Messages.APARTMENT_NUMBER_NOT_BLANK)
    @Size(min = 6, max = 6, message = Messages.APARTMENT_NUMBER_LENGTH)
    @Pattern(regexp = "[0-9]+", message = Messages.APARTMENT_NUMBER_DIGITS)
    private String apartmentNumber;
    @NotNull(message = Messages.GAMES_NOT_BLANK)
    private List<String> games;
    @NotNull(message = Messages.TRANSACTION_ID_NOT_BLANK)
    private String transactionId;
    @Min(value = 100, message = Messages.AMOUNT_MIN)
    @Max(value = 1000, message = Messages.AMOUNT_MAX)
    private int amount;
}
