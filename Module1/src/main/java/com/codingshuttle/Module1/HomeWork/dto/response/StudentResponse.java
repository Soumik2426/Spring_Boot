package com.codingshuttle.Module1.HomeWork.dto.response;

import java.util.UUID;

public record StudentResponse(
        UUID id,
        String name,
        String phnNumber
) {
}
