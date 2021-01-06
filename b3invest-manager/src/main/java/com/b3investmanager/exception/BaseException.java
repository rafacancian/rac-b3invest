package com.b3investmanager.exception;

import com.b3investmanager.exception.data.ErrorData;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Set;

@Slf4j
public class BaseException extends RuntimeException {

    static final long serialVersionUID = -9034816190742716963L;

    @Getter
    private Set<ErrorData> errors;

    public BaseException() {
        super();
    }

/*    public BaseException(final Set<ErrorData> errors) {
        this.errors = errors;
    }*/

   /* public BaseException(final ErrorData... errors) {
        this.errors = Arrays.stream(errors).collect(Collectors.toSet());
    }*/

    public BaseException(final String message) {
        super(message);
    }

   /* public BaseException(final String message, final Set<ErrorData> errors) {
        super(message);
        this.errors = errors;
    }*/

    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

   /* public BaseException(final String message, final Throwable cause, final Set<ErrorData> errors) {
        super(message, cause);
        this.errors = errors;
    }*/

    /*public BaseException(final Throwable cause) {
        super(cause);
    }*/

    /*public BaseException(final Throwable cause, final Set<ErrorData> errors) {
        super(cause);
        this.errors = errors;
    }*/

   /* public BaseException(final String tag, final Throwable cause, final String[] args) {
        super(getMessage(tag, args), cause);
    }*/

    private static String getMessage(final String tag, final String[] args) {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("messages/messages");
        return messageSource.getMessage(tag, args, LocaleContextHolder.getLocale());
    }
}