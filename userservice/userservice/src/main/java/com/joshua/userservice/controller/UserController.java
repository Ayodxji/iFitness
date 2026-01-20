package com.joshua.userservice.controller;

import com.joshua.userservice.dto.UserProfileResponseDTO;

import com.joshua.userservice.dto.UserRegistrationRequestDTO;
import com.joshua.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileResponseDTO> getUserProfile(@PathVariable UUID userId){
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
    @PostMapping("/register")
    public ResponseEntity<UserProfileResponseDTO> registerUser(@Valid @RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        return ResponseEntity.ok(userService.registerUser(userRegistrationRequestDTO));

    }

}
