package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CancelPaymentByIdempotencyKeyResponse {

    @JsonCreator
    public CancelPaymentByIdempotencyKeyResponse(
            @JsonProperty("errors") List<Error> errors) {
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<Error> errors;

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CancelPaymentByIdempotencyKeyResponse)) {
            return false;
        }
        CancelPaymentByIdempotencyKeyResponse cancelPaymentByIdempotencyKeyResponse = (CancelPaymentByIdempotencyKeyResponse) o;
        return Objects.equals(errors, cancelPaymentByIdempotencyKeyResponse.errors);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }

        public CancelPaymentByIdempotencyKeyResponse build() {
            CancelPaymentByIdempotencyKeyResponse model = new CancelPaymentByIdempotencyKeyResponse(errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
