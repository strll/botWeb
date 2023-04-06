package com.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.entity.Root;
import com.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RootServiceImpl rootService;
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        Root root = rootService.loginRoot(name, pwd);
        if (null!=root){
            Integer id = root.getId();
            StpUtil.login(id,60*60*24*30);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }
}
