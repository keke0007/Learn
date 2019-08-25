package com.swagger.common;

/**
 * @ Author：ke
 * @ Date： 2019/5/13 19:53
 * @ Version 1.0
 */

/**
 * 响应实体
 */
public class Result {
    private Integer code;//响应码
    private Boolean flag;//响应标记
    private String message;//响应信息
    private Object data;//返回数据

    public Result() {
    }

    public Result(Boolean flag,Integer code,  String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }

    public Result(Boolean flag,Integer code,  String message, Object data) {
        this.code = code;
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
