package org.zhezii.commons.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.zhezii.model.User;

/**
 * 密码加密工具类
 *
 * @author Zhou Wenzhe
 * @date 2019/6/7
 */
public class ShiroEncryption {

    public static String shiroEncryption(String password) {

        //加密算法的名称
        String algorithmName = "md5";

        //加密用到的salt
        String salt = new User().getCredentialsSalt();

        //加密的次数
        int time = 2;

        return new SimpleHash(algorithmName, password, salt, time).toString();
    }
}
