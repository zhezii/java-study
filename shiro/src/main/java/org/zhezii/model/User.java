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
public class User implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Date createTime;
    private String nickName;
    private Integer status;

    private List<Role> roleList;

    public String getCredentialsSalt() {
        return username + "8d78869f470951332959580424d4bf4f";
    }
}
