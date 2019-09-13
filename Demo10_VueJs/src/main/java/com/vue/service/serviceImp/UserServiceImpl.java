package com.vue.service.serviceImp;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vue.domain.User;
import com.vue.mapper.UserMapper;
import com.vue.service.UserService;
/**
 * @ Author：ke
 * @ Date： 2019/9/13 15:02
 * @ Version 1.0
 */  

     
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
