package com.iris.userServer.controller;

/**
 * @author iris
 * @date 2020/4/16
 */
public class APIResponse {
    private String message;
    private Integer code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
