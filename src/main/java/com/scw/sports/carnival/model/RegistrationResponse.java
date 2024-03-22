package com.scw.sports.carnival.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegistrationResponse {
    private String message;
    private RegistrationDetails details;
    private RegistrationRequest requestDetails;
}
