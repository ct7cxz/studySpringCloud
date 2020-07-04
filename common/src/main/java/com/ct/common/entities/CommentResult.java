package com.ct.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResult<T> {

    private int code;
    private String message;
    private T data;

    public CommentResult(int code,String message) {
        this.code = code;
        this.message =message;
    }

    public CommentResult data(T data) {
        this.data = data;
        return this;
    }
}
