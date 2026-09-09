package com.codingshuttle.Module1.HomeWork.clients.impl;

import com.codingshuttle.Module1.HomeWork.advice.ApiResponse;
import com.codingshuttle.Module1.HomeWork.clients.userClient;
import com.codingshuttle.Module1.HomeWork.dto.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.nio.file.NoSuchFileException;

@Service
@RequiredArgsConstructor
public class UserClientImpl implements userClient {

    private final RestClient restClient;
    Logger log= LoggerFactory.getLogger(UserClientImpl.class);

    @Override
    public UserResponse registerUser(RegisterRequest registerRequest) {
        log.info("Registering User");
        try{
            log.info("Sending request to user service for registration");
            ApiResponse<UserResponse> response=restClient.post()
                    .uri("/auth/registerUser")
                    .body(registerRequest)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res)->{
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new NoSuchFileException("Client error occurred while registering user");
                    })
                    .body(new ParameterizedTypeReference<ApiResponse<UserResponse>>() {});
            log.info("User Registered Successfully");
            return response.getData();
        } catch (Exception e) {
            log.error("Error occurred while registering user: ", e);
            throw new RuntimeException(e);
        }
    }
}
