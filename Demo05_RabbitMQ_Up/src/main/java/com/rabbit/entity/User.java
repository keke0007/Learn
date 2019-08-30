package com.rabbit.entity;/**
 * @Author ke
 * @create 2019/8/27 16:53
 * @version 1.0.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 16:53
 */
@Data
public class User implements Serializable {
    private String name;
    private String pass;
    private int age;
    private boolean sex;
}
