package com.test.codeit.common.exception;

import com.test.codeit.common.code.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception{
    private ApiCode status;
}
