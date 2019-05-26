package org.zhezii.service;

import org.zhezii.model.User;

import java.util.List;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/25
 */
public interface UserService {

    User findByUsername(String username);

    List<User> getList();
}
