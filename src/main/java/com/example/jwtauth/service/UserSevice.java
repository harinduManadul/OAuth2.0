package com.example.jwtauth.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.jwtauth.model.User;
import com.example.jwtauth.repository.UserRepository;
import com.example.jwtauth.requestModel.LoginRequest;

@Service
public class UserSevice {

    private final UserRepository uRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public UserSevice(UserRepository uRepository, CustomUserDetailsService customUserDetailsService) {
        this.uRepository = uRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    public User save(User user){
        return uRepository.save(user);
    }

    public ResponseEntity<Map<String, String>> login(LoginRequest loginRequest) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Authentication failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}
