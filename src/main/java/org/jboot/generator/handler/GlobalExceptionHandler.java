package org.jboot.generator.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.jboot.generator.base.Result;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * GlobalExceptionHandler 全局性统一异常处理类
 * 
 * @author liwen
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception other异常处理
     * 
     * @param e
     *            Exception
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandle(Exception e) {
        return new Result<String>(ErrorCode.OTHER, "系统发生了未知错误。");
    }

    /**
     * RuntimeException 运行时异常处理类
     * 
     * @param e
     *            RuntimeException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public Result<String> handle(ApplicationException e) {
        return new Result<String>(ErrorCode.OTHER, "系统运行时发生了异常，请联系管理员。", e.getMessage());
    }

    /**
     * NullPointerException 空指针异常处理类
     * 
     * @param e
     *            NullPointerException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public Result<String> handle(NullPointerException e) {
        return new Result<String>(ErrorCode.OTHER, "系统发生了空指针异常。", e.getMessage());
    }

    /**
     * ClassCastException 类型转换发生了异常
     * 
     * @param e
     *            ClassCastException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClassCastException.class)
    public Result<String> handle(ClassCastException e) {
        return new Result<String>(ErrorCode.OTHER, "类型转换发生了异常。", e.getMessage());
    }

    /**
     * ArrayIndexOutOfBoundsException 数组下标越界
     * 
     * @param e
     *            ArrayIndexOutOfBoundsException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public Result<String> handle(ArrayIndexOutOfBoundsException e) {
        return new Result<String>(ErrorCode.OTHER, "数组下标发生了越界。", e.getMessage());
    }

    /**
     * FileNotFoundException 文件未找到
     * 
     * @param e
     *            FileNotFoundException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileNotFoundException.class)
    public Result<String> handle(FileNotFoundException e) {
        return new Result<String>(ErrorCode.OTHER, "未找到相应文件。", e.getMessage());
    }

    /**
     * NumberFormatException 字符串转换数字异常
     * 
     * @param e
     *            NumberFormatException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NumberFormatException.class)
    public Result<String> handle(NumberFormatException e) {
        return new Result<String>(ErrorCode.OTHER, "字符串转换数字异常。", e.getMessage());
    }

    /**
     * SQLException 操作数据库发生了异常
     * 
     * @param e
     *            SQLException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public Result<String> handle(SQLException e) {
        return new Result<String>(ErrorCode.OTHER, "操作数据库发生了异常。", e.getMessage());
    }

    /**
     * IOException 输入输出流异常
     * 
     * @param e
     *            IOException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    public Result<String> handle(IOException e) {
        return new Result<String>(ErrorCode.OTHER, "输入输出流异常。", e.getMessage());
    }

    /**
     * NoSuchMethodException 方法未未找到
     * 
     * @param e
     *            NoSuchMethodException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchMethodException.class)
    public Result<String> handle(NoSuchMethodException e) {
        return new Result<String>(ErrorCode.OTHER, "方法未未找到。", e.getMessage());
    }

    /**
     * OutOfMemoryError 系统内存不足
     * 
     * @param e
     *            OutOfMemoryError
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(OutOfMemoryError.class)
    public Result<String> handle(OutOfMemoryError e) {
        return new Result<String>(ErrorCode.OTHER, "系统内存不足请联系管理员。", e.getMessage());
    }

    /**
     * StackOverflowError 堆栈内存异常
     * 
     * @param e
     *            StackOverflowError
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(StackOverflowError.class)
    public Result<String> handle(StackOverflowError e) {
        return new Result<String>(ErrorCode.OTHER, "堆栈内存异常。", e.getMessage());
    }

    /**
     * ClassNotFoundException 系统找不到对应的类
     * 
     * @param e
     *            ClassNotFoundException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ClassNotFoundException.class)
    public Result<String> handle(ClassNotFoundException e) {
        return new Result<String>(ErrorCode.OTHER, "系统找不到对应的类。", e.getMessage());
    }

    /**
     * IndexOutOfBoundsException 操作数组或集合发生了索引越界
     * 
     * @param e
     *            IndexOutOfBoundsException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result<String> handle(IndexOutOfBoundsException e) {
        return new Result<String>(ErrorCode.OTHER, "操作数组或集合发生了索引越界。", e.getMessage());
    }

}
