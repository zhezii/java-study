package org.zhezii.service.impl;

import org.springframework.stereotype.Service;
import org.zhezii.commons.utils.ShiroEncryption;
import org.zhezii.mapper.UserMapper;
import org.zhezii.model.User;
import org.zhezii.service.UserService;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<User> getList() {
        return userMapper.queryList();
    }

    @Override
    public Integer delUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public Integer addUser(String username, String password, String nickname) {
        return userMapper.insertUser(username, ShiroEncryption.shiroEncryption(password), nickname);
    }

}
