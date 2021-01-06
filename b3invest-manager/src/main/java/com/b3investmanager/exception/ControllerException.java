package com.b3investmanager.exception;

import com.b3investmanager.exception.data.MetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;

import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@ControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {
    private static final long serialVersionUID = 8315180825394499599L;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(final RuntimeException exception,
                                                          final WebRequest request) {
        final EntityNotFoundException entityNotFoundException = (EntityNotFoundException) exception;
        final MetaData response = new MetaData(HttpStatus.NOT_FOUND.toString(), buildNotFoundExceptionMessage(entityNotFoundException));
        log.error("EntityNotFoundException: {}", response);
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(GatewayException.class)
    public ResponseEntity<Object> handleGatewayException(final RuntimeException exception,
                                                         final WebRequest request) {
        final GatewayException serviceException = (GatewayException) exception;
        MetaData response = new MetaData(HttpStatus.SERVICE_UNAVAILABLE.toString(), serviceException.getMessage());

        if (!isEmpty(serviceException.getErrors())) {
            response = new MetaData(HttpStatus.SERVICE_UNAVAILABLE.toString(), serviceException.getErrors());
        }

        final String errorMessage = MessageFormat.format("GatewayException: {0}", response);
        log.error(errorMessage, "exception", exception);
        return handleExceptionInternal(exception, response, new HttpHeaders(),
                HttpStatus.SERVICE_UNAVAILABLE, request);
    }

    private static String buildNotFoundExceptionMessage(final EntityNotFoundException exception) {
        final StringBuilder message = new StringBuilder();
        message.append(exception.getType()).append(" ")
                .append(exception.getIdentifier())
                .append(" not found");
        return message.toString();
    }
}
