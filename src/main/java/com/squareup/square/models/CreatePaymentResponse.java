package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;

public class CreatePaymentResponse {

    @JsonCreator
    public CreatePaymentResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("payment") Payment payment) {
        this.errors = errors;
        this.payment = payment;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final Payment payment;

    @Override
    public int hashCode() {
        return Objects.hash(errors, payment);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CreatePaymentResponse)) {
            return false;
        }
        CreatePaymentResponse createPaymentResponse = (CreatePaymentResponse) o;
        return Objects.equals(errors, createPaymentResponse.errors) &&
            Objects.equals(payment, createPaymentResponse.payment);
    }


    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() { 
        return this.errors;
    }

    /**
     * Getter for Payment.
     * Represents a payment processed by the Square API.
     */
    @JsonGetter("payment")
    public Payment getPayment() { 
        return this.payment;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .payment(getPayment());
            return builder;
    }

    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private Payment payment;

        public Builder() { }

        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        public Builder errors(List<Error> value) {
            errors = value;
            return this;
        }
        public Builder payment(Payment value) {
            payment = value;
            return this;
        }

        public CreatePaymentResponse build() {
            CreatePaymentResponse model = new CreatePaymentResponse(errors,
                payment);
            model.httpContext = httpContext;
            return model;
        }
    }
}
