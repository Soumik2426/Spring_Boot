package com.codingshuttle.Module1.HomeWork.controller;

import com.codingshuttle.Module1.HomeWork.advice.ApiResponse;
import com.codingshuttle.Module1.HomeWork.dto.request.LoginRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.RegisterRequest;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ApiResponse<String>> logIn(@RequestBody @Valid LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response){
        String token=loginService.logIn(loginRequest);
        Cookie cookie=new Cookie("token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(token));
    }
}
