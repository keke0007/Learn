package com.demo.validator;

import com.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    //校验器初始化
    @Override
    public void initialize(MyConstraint myContraint) {
        System.out.println("my validator init");
    }

    //校验的逻辑  true成功,false失败
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        System.out.println(value);
        return false;
//        return true;
    }
}
