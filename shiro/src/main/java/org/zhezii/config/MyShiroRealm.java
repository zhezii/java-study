package org.zhezii.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.zhezii.mapper.PermissionMapper;
import org.zhezii.mapper.RoleMapper;
import org.zhezii.model.Permission;
import org.zhezii.model.Role;
import org.zhezii.model.User;
import org.zhezii.service.UserService;

import javax.annotation.Resource;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/25
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        log.info(user.getUsername()+"user");
        for (Role role : roleMapper.queryRoleByUsername(user.getUsername())) {
            authorizationInfo.addRole(role.getName());
            for (Permission permission : permissionMapper.queryPermissionByRoleId(role.getId())) {
                log.info(permission.getName()+"permission");
                authorizationInfo.addStringPermission(permission.getValue());
            }
        }
        return authorizationInfo;
    }

    /**
     * 主要用来进行身份认证的,就是用户名和密码是否正确
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("MyShiroRealm.doGetAuthenticationInfo()");
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        //通过username从数据中查找User对象  默认情况下shiro两分钟内不会重复执行此方法
        User user = userService.findByUsername(username);
        log.info("------>user=" + user);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authoricationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );

        return authoricationInfo;
    }
}
