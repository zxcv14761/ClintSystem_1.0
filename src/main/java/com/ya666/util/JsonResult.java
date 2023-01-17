package com.ya666.util;

import lombok.Data;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 响应数据
 * @date 2022/7/10 23:37
 */
@Data
public class JsonResult<E> {

    private int status;

    private String message;

    private E data;

    public JsonResult() {
    }

    public JsonResult(int status) {
        this.status = status;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(int status, E data) {
        this.status = status;
        this.data = data;
    }
}
