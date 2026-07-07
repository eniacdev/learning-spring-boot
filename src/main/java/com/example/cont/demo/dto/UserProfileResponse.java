package com.example.cont.demo.dto;

import jakarta.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NegativeOrZero
public class UserProfileResponse {
    private Integer profileId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
