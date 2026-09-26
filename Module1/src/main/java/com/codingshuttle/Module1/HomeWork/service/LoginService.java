package com.codingshuttle.Module1.HomeWork.service;

import com.codingshuttle.Module1.HomeWork.dto.request.LoginRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.LoginResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.UserResponse;
import com.codingshuttle.Module1.HomeWork.entity.UserEntity;
import com.codingshuttle.Module1.HomeWork.repository.UserEntityRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final SessionService sessionService;

    public UserResponse signUp(@Valid RegisterRequest registerRequest) {
        if(userEntityRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            throw new RuntimeException("User with email already exists");
        }
        UserEntity userEntity = UserEntity.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(registerRequest.getRoles())
                .build();

        userEntity=userEntityRepository.save(userEntity);

        return new UserResponse(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail()
        );
    }

    public LoginResponse logIn(@Valid LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        UserEntity userEntity =
                (UserEntity) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(userEntity);
        String refreshToken = jwtService.generateRefreshToken(userEntity);
        sessionService.generateSession(userEntity, refreshToken);
        return new LoginResponse(
                userEntity.getId(),
                accessToken,
                refreshToken
        );

    }

    public LoginResponse refreshToken(String refreshToken) {
        UUID userId = jwtService.getUserIdFromToken(refreshToken);
        sessionService.validateSession(refreshToken);
        UserEntity userEntity = userEntityRepository.findById(userId)
                .orElseThrow(()-> new NoSuchElementException("User not found with id: " + userId));
        String accessToken = jwtService.generateAccessToken(userEntity);

        return new LoginResponse(
                userEntity.getId(),
                accessToken,
                refreshToken
        );
    }
}
