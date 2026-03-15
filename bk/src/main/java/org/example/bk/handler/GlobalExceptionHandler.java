package org.example.bk.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.trcommon.R.R;
import org.example.trcommon.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public R exceptionHandler(BaseException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }


}
