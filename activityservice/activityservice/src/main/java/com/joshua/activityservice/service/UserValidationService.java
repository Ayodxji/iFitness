package com.joshua.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    private final RestClient userServiceRestClient;

    public boolean validateUser(UUID userId){
        try{
            return userServiceRestClient.get()
                    .uri("/api/users/{userId}/validate",userId)
                    .retrieve()
                    .body(Boolean.class);
        }catch(RestClientResponseException e){
            if (e.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new RuntimeException("User with id"+userId+"not Found");
            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new RuntimeException("Invalid User iD format");

            }
        }
        return false;
    }
}
