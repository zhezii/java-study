package org.zhezii.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zhezii.model.User;
import org.zhezii.service.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value = "/query")
    @RequiresPermissions("user:view")//权限管理
    public String userList(Map<String,Object> map) {
        List<User> list = userService.getList();
        map.put("userList", list);
        return "index";
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping(value = "/add/{username}/{password}/{nickname}")
    @RequiresPermissions("user:add")//权限管理
    public String userAdd(@PathVariable("username") String username,
                          @PathVariable("password") String password,
                          @PathVariable("nickname") String nickname) {
        Integer result = userService.addUser(username, password, nickname);
        return "userAdd";
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping(value = "/del/{userId}")
    @RequiresPermissions("user:del")//权限管理
    public String userDel(@PathVariable("userId") int id) {
        Integer result = userService.delUser(id);
        return "userDel";
    }
}
