package com.b3investmanager.exception.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetaData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String statusCode;
    private Set<ErrorData> errors;


    public MetaData(final String statusCode, final Set<ErrorData> errors) {
        this.statusCode = statusCode;
        this.errors = errors;
    }

    public MetaData(final String statusCode, final String message) {
        this.statusCode = statusCode;
        this.errors = new HashSet<>(Collections.singleton(new ErrorData(message)));
    }
}
