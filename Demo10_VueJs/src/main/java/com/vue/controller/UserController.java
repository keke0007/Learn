package com.vue.controller;

import com.vue.domain.User;
import com.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author：ke
 * @ Date： 2019/9/13 15:18
 * @ Version 1.0
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll")
    public List<User> findAll() {
        return userService.list();
    }

    @RequestMapping(value = "findById")
    public User findById(@RequestParam("id") String id) {
       return userService.getById(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }
}
