package org.zhezii.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
    private String url;//前端资源路径
    private int type;//0:目录 1:菜单 2:按钮
    private Date createTime;
    private int status;//状态标示0-->禁用  1--->启用

    private List<Role> roleList;
}
