package com.codingshuttle.Module1.Chapter2.Advices;

import com.codingshuttle.Module1.Chapter2.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //All type of Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<ApiError>> handleExceptions(Exception e){
        return ApiResponseError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
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
