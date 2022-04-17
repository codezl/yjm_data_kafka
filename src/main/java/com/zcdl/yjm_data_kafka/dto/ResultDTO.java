package com.zcdl.yjm_data_kafka.dto;

//import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Mata on 2019/9/2.
 * Use to
 */
//@Data
public class ResultDTO<T> {
    private int status;
    private String message;
    private T data;

    private ResultDTO(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

  //  @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultDTO<T> ok_data(String message, T obj) {
        return new ResultDTO<>(200, message, obj);
    }

    public static <T> ResultDTO<T> ok_data(T obj) {
        return new ResultDTO<>(200, "ok", obj);
    }

    public static ResultDTO ok_msg(String message) {
        return new ResultDTO<>(200, message, null);
    }

    public static <T> ResultDTO<T> error_data(int status, String message, T obj) {
        return new ResultDTO<>(status, message, obj);
    }

    public static <T> ResultDTO<T> ok_data(int status, String message, T obj) {
        return new ResultDTO<>(status, message, obj);
    }

    public static ResultDTO error_msg(int status, String message) {
        return new ResultDTO<>(status, message, null);
    }

}
