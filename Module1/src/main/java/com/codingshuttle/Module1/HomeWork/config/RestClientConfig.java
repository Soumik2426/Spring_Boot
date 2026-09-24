package com.codingshuttle.Module1.HomeWork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {
    @Bean
    RestClient createUserService(){
        return RestClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError, (req, res)->{
                    System.out.println("Server error occurred while calling user service");
                    throw new RuntimeException("Server error occurred");
                })
                .build();
    }
}
