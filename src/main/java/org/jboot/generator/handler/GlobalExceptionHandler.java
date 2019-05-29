package org.jboot.generator.handler;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.jboot.generator.base.Result;

/**
 * 统一异常处理类
 * 
 * @author liwen
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandle(Exception e) {
        return new Result<String>().fail();
    }

    /**
     * 
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Result<String> handle(ApplicationException ex) {
        return new Result<String>().fail();
    }

}
