package com.b3investbroker.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GatewayException extends BaseException {

    private static final long serialVersionUID = -4614302419130048495L;

    public GatewayException() {
        super();
    }

    public GatewayException(final String message) {
        super(message);
    }

    public GatewayException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
