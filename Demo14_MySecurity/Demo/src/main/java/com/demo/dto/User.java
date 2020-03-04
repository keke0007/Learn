package com.demo.dto;

import com.demo.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
public class  User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private String id;


    @MyConstraint(message = "自定义校验消息")
    @JsonView(UserSimpleView.class)
    private String username;


    @NotBlank(message = "密码不能为空")
    @JsonView(UserDetailView.class)
    private String password;


    @Past(message = "生日必须是过去的时间")
    @JsonView(UserSimpleView.class)
    private Date birthday;
}
