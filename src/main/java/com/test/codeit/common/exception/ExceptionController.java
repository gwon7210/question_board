package com.test.codeit.common.exception;


import com.test.codeit.common.CommController;
import com.test.codeit.common.code.ApiCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


@Slf4j
@RestControllerAdvice
public class ExceptionController extends CommController {


    @ExceptionHandler
    public ResponseEntity baseException(BaseException e) {
        e.printStackTrace();
        return ErrorReturn(e.getStatus());
    }

    // @RequestParam Param Error Check
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return ErrorReturn(ApiCode.PARAM_ERROR);
    }

    // @RequestParam File Error Check
    @ExceptionHandler({MissingServletRequestPartException.class})
    public ResponseEntity missingServletRequestPartException(MissingServletRequestPartException e) {
        return ErrorReturn(ApiCode.PARAM_ERROR);
    }

    // @RequestBody DTO Param Error Check
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorReturn(ApiCode.PARAM_ERROR);
    }

    // @PathVariable ERROR - 1
    @ExceptionHandler({MissingPathVariableException.class})
    public ResponseEntity missingPathVariableException(MissingPathVariableException e) {
        return ErrorReturn(ApiCode.PARAM_ERROR);
    }

    // @PathVariable ERROR - 2
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ErrorReturn(ApiCode.PARAM_ERROR);
    }

}
