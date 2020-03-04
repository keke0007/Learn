package com.demo.code;

import com.demo.security.validate.code.image.ImageCode;
import com.demo.security.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

//@Component("imageValidateCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
