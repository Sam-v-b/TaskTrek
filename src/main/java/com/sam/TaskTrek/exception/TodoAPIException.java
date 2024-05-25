package com.sam.TaskTrek.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoAPIException extends RuntimeException {
    private HttpStatus status;
    private String msg;
}
