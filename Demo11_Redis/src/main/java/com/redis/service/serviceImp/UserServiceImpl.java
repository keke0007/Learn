package com.redis.service.serviceImp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redis.entity.User;
import com.redis.mapper.UserMapper;
import com.redis.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ Author：ke
 * @ Date： 2019/9/13 15:02
 * @ Version 1.0
 */  

     
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
