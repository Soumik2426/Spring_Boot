package com.codingshuttle.Module1.HomeWork.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentRequest(
        @Column(name = "name")
        @NotNull(message = "Name is required")
        String name,

        @Column(name = "phn_number", length = 20)
        @NotNull(message = "Phone number is required")
        String phnNumber,

        @Column(name = "fees")
        @Max(value = 10000, message = "Fees cannot exceed 10000")
        @NotNull(message = "Fees is required")
        Integer fees
) {
}
