package com.zcdl.yjm_data_kafka.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MyException extends RuntimeException{
    private String message;
}
