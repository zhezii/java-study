package org.zhezii.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zhezii.model.Permission;

import java.util.List;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/26
 */
@Mapper
public interface PermissionMapper {
    List<Permission> queryPermissionByRoleId(Long roleId);
}
