package com.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.util.SaResult;
import com.entity.WebEntity.WebTodayEat;
import com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/message")
public class MessageController {
@Autowired
    private MessageService messageService;
    @GetMapping("/allmessage")
    public SaResult getallmessage(){
        List list = messageService.getallMessage();
        return  SaResult.ok().setData(list) ;
    }
    @GetMapping("/likemessage")
    public SaResult likemessage(String value){
        List list = messageService.getlikeMessage(value);
        return  SaResult.ok().setData(list) ;
    }
    @GetMapping("/deletemessage")
    public SaResult deletemessage(String id,String url){
         messageService.delectMessage(id,url);
        return  SaResult.ok() ;
    }

}

