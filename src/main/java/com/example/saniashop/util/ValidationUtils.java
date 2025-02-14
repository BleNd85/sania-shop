package com.example.saniashop.util;

import com.example.saniashop.service.exception.ParamsViolationException;
import lombok.experimental.UtilityClass;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@UtilityClass
public class ValidationUtils {
    public static ProblemDetail getValidationProblemDetail(List<ParamsViolationException> validationProblems) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(BAD_REQUEST, "Request validation failed");
        problemDetail.setType(URI.create("urn:problem-type:validation-error"));
        problemDetail.setTitle("Field Validation Exception");
        problemDetail.setProperty("invalidParams", validationProblems);
        return problemDetail;
    }
}
