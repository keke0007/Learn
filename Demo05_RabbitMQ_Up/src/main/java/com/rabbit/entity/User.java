package com.rabbit.entity;/**
 * @Author ke
 * @create 2019/8/27 16:53
 * @version 1.0.0
 */

import java.io.Serializable;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/27 16:53
 */
public class User implements Serializable {
    private String name;
    private String pass;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
