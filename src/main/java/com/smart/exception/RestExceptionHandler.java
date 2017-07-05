package com.smart.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by landy on 2017/6/30.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);
    /**
     * 处理@RequestParam错误, 即参数不足
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMissingServletRequestParameter(ex, headers, status, request);
        //return new ResponseEntity<>(new MatrixResponse(ErrorCode.ARG_INVALID), status);
    }

    /**
     * 处理500错误
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error("got internal error --------------------: {}", ex);
        return super.handleExceptionInternal(ex, body, headers, status, request);
        // 请求方式不支持
//        if (ex instanceof HttpRequestMethodNotSupportedException) {
//            return new ResponseEntity<>(new MatrixResponse(ErrorCode.REQUEST_METHOD_UNSUPPORTED), status);
//        }
//
//        return new ResponseEntity<>(new MatrixResponse(ErrorCode.INTERNAL_ERROR), status);
    }


    /**
     * 处理参数类型转换失败
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //log.error("type mismatch");
        return super.handleTypeMismatch(ex, headers, status, request);
        //return new ResponseEntity<>(new MatrixResponse(ErrorCode.ARG_INVALID), status);
    }

    
}
