package com.b3investmanager.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GatewayException extends BaseException {

    private static final long serialVersionUID = -4614302419130048495L;

    public GatewayException() {
        super();
    }

   /* public GatewayException(final String message, final Set<ErrorData> errors) {
        super(message, errors);
    }*/

   /* public GatewayException(final Set<ErrorData> errors) {
        super(errors);
    }*/

   /* public GatewayException(final ErrorData... errors) {
        super(errors);
    }*/

    public GatewayException(final String message) {
        super(message);
    }

    public GatewayException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /*public GatewayException(final Throwable cause) {
        super(cause);
    }*/

   /* public GatewayException(final String tag, final Throwable cause, final String[] args) {
        super(tag, cause, args);
    }*/
}
