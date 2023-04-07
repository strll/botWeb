package com.controller;



import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.StrUtil;
import com.entity.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@CrossOrigin
@RestController
@SaCheckLogin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAllAdmin")

    public SaResult getallAdmin(@CookieValue("satoken") String sessionId){
        System.out.println("登陆?"+StpUtil.isLogin());
        return new SaResult().ok().setData(adminService.getAllAdmin());
    }


    @GetMapping("/updateAdmin")
    public SaResult updateAdmin(String account,String permission){
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPermission(permission);
        adminService.updateAdmin(admin);
        return new SaResult().ok();
    }

    @GetMapping("/deleteAdmin")
    public SaResult deleteAdmin(String account,String permission){
        if ( !StrUtil.isEmpty(account)&&!StrUtil.isEmpty(permission)){
            Admin admin = new Admin();
            admin.setAccount(account);
            admin.setPermission(permission);
            adminService.delAdmin(admin);
            return new SaResult().ok();
        }else {
            return new SaResult().error();
        }


    }

    @GetMapping("/addAdmin")
    public SaResult addAdmin(String account,String permission){
        Admin admin = new Admin();
        admin.setAccount(account);
        admin.setPermission(permission);
        adminService.addAdmin(admin);
        return new SaResult().ok();
    }


}


