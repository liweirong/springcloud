/*
package com.iris.userServer.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @author iris
 * @date 2020/4/16
 *//*

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @Resource
    MessageSource messageSource;
    @ExceptionHandler({
            org.springframework.web.bind.MissingServletRequestParameterException.class
    }
    )
    @ResponseBody
    public APIResponse proceequestParameterException(HttpServletRequest request,
                             HttpServletResponse response,
                             MissingServletRequestParameterException e) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        APIResponse result = new APIResponse();
        result.setCode(ApiResultStatus.BAD_REQUEST.getApiResultStatus());
        result.setMessage(
                messageSource.getMessage(ApiResultStatus.BAD_REQUEST.getMessageResourceName(),
                        null, LocaleContextHolder.getLocale()) + e.getParameterName());
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public APIResponse processDefaultException(HttpServletResponse response,
                                               Exception e) {
        //log.error("Server exception", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
        APIResponse result = new APIResponse();
        result.setCode(ApiResultStatus.INTERNAL_SERVER_ERROR.getApiResultStatus());
        result.setMessage(messageSource.getMessage(ApiResultStatus.INTERNAL_SERVER_ERROR.getMessageResourceName(), null,
                LocaleContextHolder.getLocale()));
        return result;
    }

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public APIResponse processApiException(HttpServletResponse response,
                                           ApiException e) {
        APIResponse result = new APIResponse();
        response.setStatus(e.getApiResultStatus().getHttpStatus());
        response.setContentType("application/json;charset=UTF-8");
        result.setCode(e.getApiResultStatus().getApiResultStatus());
        String message = messageSource.getMessage(e.getApiResultStatus().getMessageResourceName(),
                null, LocaleContextHolder.getLocale());
        result.setMessage(message);
        //log.error("Knowned exception", e.getMessage(), e);
        return result;
    }

    */
/**
     * 内部微服务异常统一处理方法
     *//*

    @ExceptionHandler(InternalApiException.class)
    @ResponseBody
    public APIResponse processMicroServiceException(HttpServletResponse response,
                                                    InternalApiException e) {

        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        APIResponse result = new APIResponse();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        return result;
    }
}*/
