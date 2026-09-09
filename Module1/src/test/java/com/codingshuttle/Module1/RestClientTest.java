package com.codingshuttle.Module1;

import com.codingshuttle.Module1.HomeWork.clients.impl.UserClientImpl;
import com.codingshuttle.Module1.HomeWork.dto.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestClientTest {
    @Autowired
    private UserClientImpl userClient;

    @Test
    void contextLoads() {
    }

    @Test
    void testRestClient() {
        RegisterRequest request = RegisterRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john123@gmail.com")
                .password("Sooumik@1234")
                .build();

        UserResponse response = userClient.registerUser(request);
        System.out.println(response);
    }
}
