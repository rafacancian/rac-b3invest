package com.b3investbroker.adapter;


import com.b3investbroker.model.ResponseVO;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

public class ResponseVOAdapter {

    public static ResponseVO create(final ResponseEntity response) {

        if (!ObjectUtils.isEmpty(response.getBody())) {
            return new ModelMapper().map(response.getBody(), ResponseVO.class);
        }
        return ResponseVO.builder().build();
    }

}
