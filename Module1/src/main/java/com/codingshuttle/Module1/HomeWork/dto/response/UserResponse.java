package com.codingshuttle.Module1.HomeWork.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;
}
