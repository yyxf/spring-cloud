package com.pxz.consumer.model.response;

/**
 * @author YangSheng
 * @Package com.qckj.core.response
 * @date 2018/10/19 15:27
 */
public enum StatusCode {
    // 成功
    SUCCESS(200, "success."),

    // 服务器错误
    INTERNAL_ERROR(500, "failed."),

    // 找不到数据
    NOT_FOUND(404, "not found."),

    // 请求错误（语义有误、参数有误等）
    PARAM_ERROR(400, "parameter error."),

    // 数量溢出
    OUT_OF_NUMBER(401, "out of number."),

    UNAUTHORIZED(403, "UNAUTHORIZED"),

    // 请求错误（语义有误、参数有误等）
    ERROR(400, "failed.");

    private int code;
    private String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
