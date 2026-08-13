package com.codingshuttle.Module1.Chapter3.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Cdto {
    private final long id;
    private final String productName;
    private final String productSerialCode;
}
