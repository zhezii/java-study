package org.zhezii.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhezii.model.User;

import java.util.List;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/26
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 获取用户信息列表
     * @return
     */
    List<User> queryList();
}
