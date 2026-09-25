package com.codingshuttle.Module1.HomeWork.controller;

import com.codingshuttle.Module1.HomeWork.advice.ApiResponse;
import com.codingshuttle.Module1.HomeWork.dto.request.LoginRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.LoginResponse;
import com.codingshuttle.Module1.HomeWork.dto.response.UserResponse;
import com.codingshuttle.Module1.HomeWork.service.impl.LoginService;
import com.codingshuttle.Module1.HomeWork.service.impl.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService loginService;

    @PostMapping("/signUp")
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(loginService.signUp(registerRequest));
    }

    @PostMapping("/logIn")
    public ResponseEntity<LoginResponse> logIn(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response){
        LoginResponse tokens=loginService.logIn(loginRequest);
        Cookie cookie=new Cookie("refreshToken", tokens.RefreshToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK)
                .body(tokens);
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(HttpServletRequest request) {
        String refreshToken = Arrays.stream(request.getCookies()).
                filter(cookie -> "refreshToken".equals(cookie.getName()))
                .findFirst()
                .map(Cookie::getValue)
                .orElseThrow(() -> new AuthenticationServiceException("Refresh token not found inside the Cookies"));
        LoginResponse loginResponse = loginService.refreshToken(refreshToken);

        return ResponseEntity.status(HttpStatus.OK)
                .body(loginResponse);
    }
}
