package com.b3investbroker.exception.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public ErrorData(final ErrorData errorData) {
        this.message = errorData.message;
    }
}
