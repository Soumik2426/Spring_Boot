package com.codingshuttle.Module1;

import com.codingshuttle.Module1.HomeWork.entity.UserEntity;
import com.codingshuttle.Module1.HomeWork.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class JwtTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void Test1() {
        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID())
                .email("user@example.com")
                .password("password123")
                .build();

        String token = jwtService.generateToken(user);
        System.out.println(token);
        UUID ID = jwtService.getUserIdFromToken(token);
        System.out.println(ID);
    }
}
