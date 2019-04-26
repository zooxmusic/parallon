package com.parallon.coding.challenge.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Response Object")
public class BaseResult<T> {
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "Success";

    @ApiModelProperty(value = "Response Code", name = "code", required = true, example = "" + SUCCESS_CODE)
    private int code;

    @ApiModelProperty(value = "Response Message", name = "message", required = true, example = SUCCESS_MESSAGE)
    private String message;

    @ApiModelProperty(value = "Response Data", name = "data")
    private T data;

    private BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private BaseResult() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    private BaseResult(int code, String message) {
        this(code, message, null);
    }

    private BaseResult(T data) {
        this(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<>();
    }

    public static <T> BaseResult<T> successWithData(T data) {
        return new BaseResult<>(data);
    }

    public static <T> BaseResult<T> failWithCodeAndMsg(int code, String msg) {
        return new BaseResult<>(code, msg, null);
    }

    public static <T> BaseResult<T> buildWithParam(ResponseParam param) {
        return new BaseResult<>(param.getCode(), param.getMessage(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class ResponseParam {
        private int code;
        private String message;

        private ResponseParam(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public static ResponseParam buildParam(int code, String message) {
            return new ResponseParam(code, message);
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}