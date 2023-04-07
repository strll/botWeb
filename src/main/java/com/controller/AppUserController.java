package com.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.util.SaResult;
import com.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * app端的用户表 前端控制器
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@CrossOrigin
@RestController
@SaCheckLogin
@RequestMapping("/appuser")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/getuserPage")
    public SaResult getuserPage(){

        return    SaResult.ok().setData( appUserService.getAppUser()) ;

    }


}

