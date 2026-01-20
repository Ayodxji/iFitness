package com.joshua.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequestDTO(
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        @Email(message = "Invalid Email Format")
        @NotBlank(message = "Email can not be empty")
        String email,
        @NotBlank(message = "Password can not be blank")
        @Size(min = 7,message = "Password must be at least 7 characters")
        String password) {
}
