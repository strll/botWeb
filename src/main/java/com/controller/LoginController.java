package com.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.entity.LoginData;
import com.entity.Root;
import com.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        Root root = rootService.loginRoot(name, pwd);
        if (null!=root){
            Integer id = root.getId();
            StpUtil.login(id);
       //     return SaResult.ok("登录成功");
            return SaResult.ok("登录成功").setData(StpUtil.getTokenInfo());
        }
        return SaResult.error("登录失败").setData(null);
    }
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }
    @RequestMapping("Login")
    public void isLogin1() {
        StpUtil.login(111);
    }

}
