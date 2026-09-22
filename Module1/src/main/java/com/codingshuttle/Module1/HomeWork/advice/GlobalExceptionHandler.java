package com.codingshuttle.Module1.HomeWork.advice;

import com.codingshuttle.Module1.HomeWork.Exceptions.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleExceptionNotFound(ResourceNotFoundException exception){
        return ApiResponseError(HttpStatus.NOT_FOUND,exception.getMessage(),null);
    }

    //Binding Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleMethodException(MethodArgumentNotValidException exception){
        List<String> errors= exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error->error.getDefaultMessage())
                .collect(Collectors.toList());

        return ApiResponseError(HttpStatus.BAD_REQUEST,"Validation Error",errors);
    }

    //Authentication Exception
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleAuthenticationException(AuthenticationException exception){
        return ApiResponseError(HttpStatus.UNAUTHORIZED, exception.getMessage(), null);
    }

    //JWT Exception
    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse<ApiError>> handleJwtException(JwtException exception){
        return ApiResponseError(HttpStatus.UNAUTHORIZED, exception.getMessage(), null);
    }

    //Helper Method
    private ResponseEntity<ApiResponse<ApiError>> ApiResponseError(HttpStatus status, String message, List<String>
            subErrors){
        ApiError apiError=ApiError.builder()
                .status(status)
                .message(message)
                .subErrors(subErrors)
                .build();
        ApiResponse<ApiError> apiResponse=new ApiResponse<>(apiError);
        return new ResponseEntity<>(apiResponse, status);
    }
}
