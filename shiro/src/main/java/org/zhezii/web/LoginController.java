package org.zhezii.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Zhou Wenzhe
 * @date 2019/5/26
 */
@RequestMapping("/")
@Controller
@Slf4j
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, Map<String, Object> map) {
        log.info("UserController.login()");
        //登录失败从request中获取shiro处理的异常信息
        //shiroLoginFailure：就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");
        log.info("exception===" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                log.info("UnknownAccountException---->账号不存在：");
                msg = "UnknownAccountException--->账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                log.info("IncorectCredentialsException---->密码不正确");
                msg = "IncorectCredentialsException---->密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                log.info("kaptchaValidateFailed---->验证码不正确");
                msg = "kaptchaValidateFailed---->验证码不正确";
            } else {
                msg = "else >>>" + exception;
                log.info("else--->"+exception);
            }
        }
        map.put("msg", msg);
        //此方法不处理登录成功的情况，由shiro处理
        return "login";
    }

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "403";
    }
}
