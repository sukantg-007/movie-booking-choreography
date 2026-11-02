package org.vedantacomp.saga.exception;

public class SagaNotFoundException extends RuntimeException {

    public SagaNotFoundException(String message) {
        super(message);
    }
}
