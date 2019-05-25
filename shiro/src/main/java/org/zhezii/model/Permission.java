package org.zhezii.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/25
 */
@Data
public class Permission implements Serializable {

    private Long id;
    private Long pid;//父级权限id
    private String name;//名称
    private String value;//权限值
    private String uri;//前端资源路径
    private int status;//状态标示0-->禁用  1--->启用

    private List<Role> roleList;
}
