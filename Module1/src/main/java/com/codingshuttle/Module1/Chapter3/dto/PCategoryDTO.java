package com.codingshuttle.Module1.Chapter3.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PCategoryDTO {
    private final String productCategory;
    private final Long count;
}
