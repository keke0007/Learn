package com.swagger.common;

/**
 * @ Author：ke
 * @ Date： 2019/5/13 20:00
 * @ Version 1.0
 */

/**
 * 响应状态码
 */
public class StatusCode {
    public static final int OK = 20000;//成功响应
    public static final int ERROR = 20001;//响应失败的状态码
    public static final int USER_PWD_ERROR = 20002;//用户名或者密码错误
    public static final int AUTHORIZATION_ERROR = 20003;//权限不足
    public static final int REMOTE_ERROR = 20004;//远程调用失败
    public static final int REPEATE_ERROR = 20005;//重复操作

}
