package com.intuit.domain.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidResponse {

    @JsonProperty
    private final boolean valid = false;

    private final String code;

    private final String message;

    public InvalidResponse(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isValid() {
        return valid;
    }
}
