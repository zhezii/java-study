package org.zhezii.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "userList")
    @RequiresPermissions("user:view")//权限管理
    public String userList() {
        return "userList";
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping(value = "userAdd")
    @RequiresPermissions("user:add")//权限管理
    public String userAdd() {
        return "userAdd";
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping(value = "userDel")
    @RequiresPermissions("user:del")//权限管理
    public String userDel() {
        return "userDel";
    }
}
