package com.example.saniashop.web;

import com.example.saniashop.service.exception.ParamsViolationException;
import com.example.saniashop.service.exception.category.CategoryNotFoundException;
import com.example.saniashop.service.exception.user.UserNotFoundException;
import com.example.saniashop.service.exception.user.UserOldPasswordException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.net.URI.create;

import java.util.List;

import static com.example.saniashop.util.ValidationUtils.getValidationProblemDetail;

@ControllerAdvice
@Slf4j
public class ExceptionTranslator extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        List<ParamsViolationException> validationResponse =
                errors.stream().map(err -> ParamsViolationException.builder().reason(err.getDefaultMessage()).fieldName(err.getField()).build()).toList();
        log.info("Input params validation failed");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(getValidationProblemDetail(validationResponse));
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ProblemDetail> handleUserNotFoundException(UserNotFoundException ex) {
        log.info("User not found exception raised");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setType(create("user-not-found"));
        problemDetail.setTitle("User not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    ResponseEntity<ProblemDetail> handleUserNotFoundException(CategoryNotFoundException ex) {
        log.info("Category not found exception raised");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setType(create("category-not-found"));
        problemDetail.setTitle("Category not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(UserOldPasswordException.class)
    ResponseEntity<ProblemDetail> handleUserOldPasswordException(UserOldPasswordException ex) {
        log.info("User same old password exception raised");
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setType(create("user-old-password-error"));
        problemDetail.setTitle("You can't use old password");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }
}
