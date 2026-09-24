package com.codingshuttle.Module1.HomeWork.clients;

import com.codingshuttle.Module1.HomeWork.dto.request.RegisterRequest;
import com.codingshuttle.Module1.HomeWork.dto.response.UserResponse;

public interface userClient {
    UserResponse registerUser(RegisterRequest registerRequest);
}
