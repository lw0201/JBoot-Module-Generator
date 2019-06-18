package org.jboot.generator.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.jboot.generator.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * GlobalExceptionHandler 全局性统一异常处理类
 * 
 * @author liwen
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Exception 异常处理
     * 
     * @param e
     *            Exception
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody Result<String> handle(Exception e) {
        logger.error("系统发生了未知错误。", e);
        return new Result<String>(ErrorCode.OTHER, "系统发生了未知错误。");
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
    public @ResponseBody Result<String> handle(NullPointerException e) {
        logger.error("系统发生了空指针异常。", e);
        return new Result<String>(ErrorCode.NULL_POINTER, "系统发生了空指针异常。", e.getMessage());
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
    public @ResponseBody Result<String> handle(ClassCastException e) {
        logger.error("类型转换发生了异常。", e);
        return new Result<String>(ErrorCode.CLASS_CAST, "类型转换发生了异常。", e.getMessage());
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
    public @ResponseBody Result<String> handle(ArrayIndexOutOfBoundsException e) {
        logger.error("数组下标发生了越界。", e);
        return new Result<String>(ErrorCode.INDEX_OUTOF, "数组下标发生了越界。", e.getMessage());
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
    public @ResponseBody Result<String> handle(FileNotFoundException e) {
        logger.error("未找到相应文件。", e);
        return new Result<String>(ErrorCode.FILE_NOT_FOUND, "未找到相应文件。", e.getMessage());
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
    public @ResponseBody Result<String> handle(NumberFormatException e) {
        logger.error("字符串转换数字异常。", e);
        return new Result<String>(ErrorCode.NUMBER_FORMAT, "字符串转换数字异常。", e.getMessage());
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
    public @ResponseBody Result<String> handle(SQLException e) {
        logger.error("操作数据库发生了异常。", e);
        return new Result<String>(ErrorCode.SQL_ERROR, "操作数据库发生了异常。", e.getMessage());
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
    public @ResponseBody Result<String> handle(IOException e) {
        logger.error("输入输出流异常。", e);
        return new Result<String>(ErrorCode.IO_ERROR, "输入输出流异常。", e.getMessage());
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
    public @ResponseBody Result<String> handle(NoSuchMethodException e) {
        logger.error("方法未未找到。", e);
        return new Result<String>(ErrorCode.NO_SUCH_METHOD, "方法未未找到。", e.getMessage());
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
        logger.error("系统内存不足请联系管理员。", e);
        return new Result<String>(ErrorCode.OUTOF_MEMORY_ERROR, "系统内存不足请联系管理员。", e.getMessage());
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
    public @ResponseBody Result<String> handle(StackOverflowError e) {
        logger.error("堆栈内存异常。", e);
        return new Result<String>(ErrorCode.STACK_OVER_FLOW_ERROR, "堆栈内存异常。", e.getMessage());
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
    public @ResponseBody Result<String> handle(ClassNotFoundException e) {
        logger.error("系统找不到对应的类。", e);
        return new Result<String>(ErrorCode.CLASS_NOT_FOUND, "系统找不到对应的类。", e.getMessage());
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
    public @ResponseBody Result<String> handle(IndexOutOfBoundsException e) {
        logger.error("操作数组或集合发生了索引越界。", e);
        return new Result<String>(ErrorCode.INDEX_OUTOF, "操作数组或集合发生了索引越界。", e.getMessage());
    }

    /**
     * DuplicateKeyException 违反了数据库约束
     * 
     * @param e
     *            DuplicateKeyException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DuplicateKeyException.class)
    public @ResponseBody Result<String> handle(DuplicateKeyException e) {
        logger.error("违反了数据库约束。", e);
        return new Result<String>(ErrorCode.DUPLICATE_KEY, "违反了数据库约束。", "数据已经存在库中。");
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
    public @ResponseBody Result<String> handle(RuntimeException e) {
        logger.error("系统运行时发生了异常，请联系管理员。", e);
        return new Result<String>(ErrorCode.RUNTIME, "系统运行时发生了异常，请联系管理员。", e.getMessage());
    }

    /**
     * MissingServletRequestParameterException 缺少请求参数
     * 
     * @param e
     *            MissingServletRequestParameterException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody Result<String> handle(MissingServletRequestParameterException e) {
        logger.error("缺少请求参数。", e);
        return new Result<String>(ErrorCode.BAD_REQUEST, "缺少请求参数。", e.getMessage());
    }

    /**
     * HttpMessageNotReadableException 参数解析失败
     * 
     * @param e
     *            HttpMessageNotReadableException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody Result<String> handle(HttpMessageNotReadableException e) {
        logger.error("参数解析失败。", e);
        return new Result<String>(ErrorCode.BAD_REQUEST, "参数解析失败。", e.getMessage());
    }

    /**
     * MethodArgumentNotValidException 参数验证失败
     * 
     * @param e
     *            MethodArgumentNotValidException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody Result<Map<String, String>> handle(MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        List<ObjectError> results = result.getAllErrors();
        Map<String, String> map = new HashMap<String, String>();
        for (ObjectError objectError : results) {
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(objectError));
            String field = jsonObject.getString("field");
            String defaultMessage = jsonObject.getString("defaultMessage");
            map.put(field, defaultMessage);
        }
        return new Result<Map<String, String>>(ErrorCode.VALID_ERROR, "参数验证失败", map);
    }

    /**
     * BindException 参数绑定失败
     * 
     * @param e
     *            BindException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public @ResponseBody Result<List<ObjectError>> handle(BindException e) {
        logger.error("参数绑定失败", e);
        List<ObjectError> errors = e.getAllErrors();
        return new Result<List<ObjectError>>(ErrorCode.BIND_ERROR, "参数绑定失败.", errors);
    }

    /**
     * ConstraintViolationException 参数验证失败
     * 
     * @param e
     *            ConstraintViolationException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public @ResponseBody Result<Set<ConstraintViolation<?>>> handle(ConstraintViolationException e) {
        logger.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        // ConstraintViolation<?> violation = violations.iterator().next();
        // String message = violation.getMessage();
        return new Result<Set<ConstraintViolation<?>>>(ErrorCode.VALID_ERROR, "参数验证失败。", violations);
    }

    /**
     * ValidationException e 参数验证失败
     * 
     * @param e
     *            ValidationException e
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public @ResponseBody Result<String> handle(ValidationException e) {
        logger.error("参数验证失败。", e);
        return new Result<String>(ErrorCode.VALID_ERROR, "参数验证失败。", e.getMessage());
    }

    /**
     * Not Found
     * 
     * @param e
     *            NoHandlerFoundException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public @ResponseBody Result<String> handle(NoHandlerFoundException e) {
        logger.error("Not Found。", e);
        return new Result<String>(ErrorCode.NOT_FOUND, "Not Found。", e.getMessage());
    }

    /**
     * HttpRequestMethodNotSupportedException 不支持当前请求方法。
     * 
     * @param e
     *            HttpRequestMethodNotSupportedException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public @ResponseBody Result<String> handle(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法。", e);
        return new Result<String>(ErrorCode.METHOD_NOT_ALLOWED, "不支持当前请求方法。", e.getMessage());
    }

    /**
     * 不支持当前媒体类型
     * 
     * @param e
     *            HttpMediaTypeNotSupportedException
     * @return Result<String>
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public @ResponseBody Result<String> handle(HttpMediaTypeNotSupportedException e) {
        logger.error("不支持当前媒体类型。", e);
        return new Result<String>(ErrorCode.UNSUPPORTED_MEDIA_TYPE, "不支持当前媒体类型。", e.getMessage());
    }

}
