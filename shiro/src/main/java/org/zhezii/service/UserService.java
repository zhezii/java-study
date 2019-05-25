package org.zhezii.service;

import org.zhezii.model.Role;
import org.zhezii.model.User;

import java.util.List;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/25
 */
public interface UserService {
    List<Role> getRoleList();

    User findByUsername(String username);
}
