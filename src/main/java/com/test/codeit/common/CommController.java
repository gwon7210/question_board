package com.test.codeit.common;

import com.test.codeit.common.code.ApiCode;
import com.test.codeit.dto.ErrorResponseDto;
import com.test.codeit.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public class CommController  {

    public ResponseEntity saveSuccessReturn(Object id) {
        return ResponseEntity.ok().body(
                ResponseDto.builder().id(id).build());
    }

    public ResponseEntity findSuccessReturn(Object data) {
        return ResponseEntity.ok().body(data);
    }

    public ResponseEntity ErrorReturn(ApiCode apiCode) {
        return ResponseEntity.ok().body(
                ErrorResponseDto.builder().statusCode(apiCode.getCode()).codeMsg(apiCode.getMsg()).build());
    }

}
