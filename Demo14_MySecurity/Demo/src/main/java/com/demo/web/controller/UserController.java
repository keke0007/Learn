package com.demo.web.controller;

import com.demo.dto.User;
import com.demo.dto.UserQueryCondition;
import com.demo.ecception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @JsonView(User.UserSimpleView.class)
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 2, size = 10, sort = "username,asc") Pageable page) {

//        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
//        //TODO 测试Pageable
//        System.out.println(page.getPageSize());
//        System.out.println(page.getPageNumber());
//        System.out.println(page.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @JsonView(User.UserDetailView.class)
    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public User getInfo(@PathVariable("id") String id) {
        System.out.println("进入getInfo服务");
//        throw new UserNotExistException(id);
//        throw new RuntimeException("用户不存在");
        User user = new User();
        user.setId(id);
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User inserUser(@Valid @RequestBody User user/*, BindingResult errors*/) {
        /*if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                System.out.println(fieldError.getField() + " " + error.getDefaultMessage());
            });
        }*/
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;

    }

    @PutMapping(value = "/{id:\\d+}")
    public User updateUser(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                System.out.println(fieldError.getField() + " " + error.getDefaultMessage());
            });
        }
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;

    }

    @JsonView(User.UserDetailView.class)
    @DeleteMapping(value = "/{id:\\d+}")
    public void deleteUser(@ApiParam("用户id") @PathVariable("id") String id) {
        System.out.println(id);
    }
}
