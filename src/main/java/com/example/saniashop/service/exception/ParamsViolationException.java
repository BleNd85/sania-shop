package com.example.saniashop.service.exception;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ParamsViolationException {

    String fieldName;

    String reason;
}
