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
public class Role implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Date createTime;
    private int status;

    private List<User> userList;

    private List<Permission> permissionList;

}
