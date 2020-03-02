package com.fantasi.xxd.exception;

/**
 * MyException:自定义异常
 * @author xxd
 * @date 2020/3/2 11:11
 */
public class MyException extends RuntimeException {

    /**
     * 自定义返回状态码
     */
    private Integer code;


    /**
     * 返回自定义的状态码和异常描述
     * @param code
     * @param message
     */
    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 只返回异常信息(默认返回500)
     * @param message
     */
    public MyException(String message) {

        super(message);
    }
}
