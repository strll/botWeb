package com.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.entity.LoginData;
import com.entity.Root;
import com.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController

@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RootServiceImpl rootService;
    @PostMapping("doLogin")
    public SaResult doLogin(@RequestBody LoginData loginData) {
       String pwd =loginData.getPassword();
       String name=loginData.getUsername();
        Root root = rootService.loginRoot(name, pwd);
        if (null!=root){
            Integer id = root.getId();
            StpUtil.login(id);
       //     return SaResult.ok("登录成功");
            String tokenValue = StpUtil.getTokenInfo().getTokenValue();
            System.out.println("登陆token为"+StpUtil.getTokenInfo().getTokenValue());
            return SaResult.ok("登录成功").setData(tokenValue);
        }
        return SaResult.error("登录失败").setData(null);
    }
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping("LoginOut")
    public SaResult LoginOut(@CookieValue("satoken") String username) {

        StpUtil.logout();
        return SaResult.ok("退出登陆");
    }
    @RequestMapping("Login")
    public void isLogin1() {
        StpUtil.login(111);
    }

}
