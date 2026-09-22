package com.codingshuttle.Module1.HomeWork.service.impl;

import com.codingshuttle.Module1.HomeWork.dto.request.LoginRequest;
import com.codingshuttle.Module1.HomeWork.dto.request.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.UserResponse;
import com.codingshuttle.Module1.HomeWork.entity.UserEntity;
import com.codingshuttle.Module1.HomeWork.repository.UserEntityRepository;
import com.codingshuttle.Module1.HomeWork.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityRepository.findByEmail(username)
                .orElseThrow(()-> new BadCredentialsException("User not found with email"));
    }

    public UserEntity getUserById(UUID id){
        return userEntityRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("User not found"));
    }
}
