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

    public BaseException(final String message) {
        super(message);
    }


    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    private static String getMessage(final String tag, final String[] args) {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("messages/messages");
        return messageSource.getMessage(tag, args, LocaleContextHolder.getLocale());
    }
}