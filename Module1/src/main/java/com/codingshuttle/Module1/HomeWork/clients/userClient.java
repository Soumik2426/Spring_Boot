package com.codingshuttle.Module1.HomeWork.clients;

import com.codingshuttle.Module1.HomeWork.advice.ApiResponse;
import com.codingshuttle.Module1.HomeWork.dto.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.UserResponse;

public interface userClient {
    UserResponse registerUser(RegisterRequest registerRequest);
}
