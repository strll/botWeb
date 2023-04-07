package com.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@CrossOrigin
@SaCheckLogin
@RestController
@RequestMapping("/root")
public class RootController {

}

