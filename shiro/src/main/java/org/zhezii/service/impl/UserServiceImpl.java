package org.zhezii.service.impl;

import org.springframework.stereotype.Service;
import org.zhezii.mapper.UserMapper;
import org.zhezii.model.User;
import org.zhezii.service.UserService;

import javax.annotation.Resource;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
