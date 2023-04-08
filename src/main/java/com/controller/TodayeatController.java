package com.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.util.SaResult;
import com.entity.WebEntity.WebTodayEat;
import com.service.impl.TodayeatServiceImpl;
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
@RequestMapping("/todayeat")
public class TodayeatController {
@Autowired
    private TodayeatServiceImpl todayeatService;
@GetMapping("/alltodayeat")
    public SaResult getallTodayeat(){
    List<WebTodayEat> allTodayeat = todayeatService.getAllTodayeat();
    return  SaResult.ok().setData(allTodayeat) ;
}
    @GetMapping("/deletetodayeat")
    public SaResult deleteTodayeat(String id){
       todayeatService.deleteTodayeat(id);
        return  SaResult.ok();
    }

    @GetMapping("/selectliketodayeat")
    public SaResult selectlikeTodayeat(String message){
       List re=  todayeatService.selectlike(message);
        return  SaResult.ok().setData(re);
    }

}

