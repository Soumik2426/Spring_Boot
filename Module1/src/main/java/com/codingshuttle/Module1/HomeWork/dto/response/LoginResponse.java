package com.codingshuttle.Module1.HomeWork.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public record LoginResponse(
        UUID id,
        String AccessToken,
        String RefreshToken
) {
}
