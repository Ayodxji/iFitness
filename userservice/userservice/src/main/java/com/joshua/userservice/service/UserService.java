package com.joshua.userservice.service;

import com.joshua.userservice.dto.UserProfileResponseDTO;
import com.joshua.userservice.dto.UserRegistrationRequestDTO;
import com.joshua.userservice.model.User;
import com.joshua.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public UserProfileResponseDTO registerUser(UserRegistrationRequestDTO userRegistrationRequest){
        if (userRepository.existsByEmail(userRegistrationRequest.email())){
            throw new RuntimeException("Email Already Exist");
        }
        User user  = new User(
                userRegistrationRequest.firstName(),
                userRegistrationRequest.lastName(),
                userRegistrationRequest.email(),
                userRegistrationRequest.password()
        );
        User savedUser = userRepository.save(user);
        return new UserProfileResponseDTO(savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail());

    }

    public UserProfileResponseDTO getUserProfile(UUID userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            return new UserProfileResponseDTO(user.getFirstName(),
            user.getLastName(),
                    user.getLastName());
        }else{
            throw new RuntimeException("User Not Found");
        }

    }
}
