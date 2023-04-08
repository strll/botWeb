package com.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.entity.RedisEntity;
import com.utils.MyRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@SaCheckLogin
@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private MyRedis myRedis;
    @GetMapping("/alltodayEat")
    public SaResult alltodayEat() {
        Set<String> todayEat = myRedis.setfindAll("todayEat");
        ArrayList<RedisEntity> redisEntities = new ArrayList<>();
        for (String s : todayEat) {
            RedisEntity redisEntity = new RedisEntity();
            redisEntity.setMessage(s);
            redisEntities.add(redisEntity);
        }
        return SaResult.ok().setData(redisEntities);
    }

    @GetMapping("/deletetodayEat")
    public SaResult deltodayEat(String deletetodayeat) {
        myRedis.setDelete("todayEat",deletetodayeat);
        return SaResult.ok();
    }
    @GetMapping("/addtodayEat")
    public SaResult addtodayEat(String addtodayeat) {
        myRedis.setAdd("todayEat",addtodayeat);
        return SaResult.ok();
    }


    @GetMapping("/allblack")
    public SaResult allblack() {
        Set<String> black = myRedis.setfindAll("black");

        ArrayList<RedisEntity> redisEntities = new ArrayList<>();
        for (String s :  black) {
            RedisEntity redisEntity = new RedisEntity();
            redisEntity.setMessage(s);
            redisEntities.add(redisEntity);
        }
        return SaResult.ok().setData(redisEntities);


    }

    @GetMapping("/deleteblack")
    public SaResult delblack(String deleteblack) {
        myRedis.setDelete("black",deleteblack);
        return SaResult.ok();
    }
    @GetMapping("/addblack")
    public SaResult addblack(String addblack) {
        myRedis.setAdd("black",addblack);
        return SaResult.ok();
    }
    //black groupReply groupStudy group_talk messagedelete
    @GetMapping("/allgroupReply")
    public SaResult allgroupReply() {
        Set<String> groupReply = myRedis.setfindAll("groupReply");

        ArrayList<RedisEntity> redisEntities = new ArrayList<>();
        for (String s :  groupReply) {
            RedisEntity redisEntity = new RedisEntity();
            redisEntity.setMessage(s);
            redisEntities.add(redisEntity);
        }
        return SaResult.ok().setData(redisEntities);


    }

    @GetMapping("/deletegroupReply")
    public SaResult delgroupReply(String deletegroupReply) {
        myRedis.setDelete("groupReply",deletegroupReply);
        return SaResult.ok();
    }
    @GetMapping("/addgroupReply")
    public SaResult addgroupReply(String addgroupReply) {
        myRedis.setAdd("groupReply",addgroupReply);
        return SaResult.ok();
    }
    @GetMapping("/allgroupStudy")
    public SaResult allgroupStudy() {
        Set<String> groupStudy = myRedis.setfindAll("groupStudy");

        ArrayList<RedisEntity> redisEntities = new ArrayList<>();
        for (String s :  groupStudy) {
            RedisEntity redisEntity = new RedisEntity();
            redisEntity.setMessage(s);
            redisEntities.add(redisEntity);
        }
        return SaResult.ok().setData(redisEntities);

    }

    @GetMapping("/deletegroupStudy")
    public SaResult delgroupStudy(String deletegroupStudy) {
        myRedis.setDelete("groupStudy",deletegroupStudy);
        return SaResult.ok();
    }
    @GetMapping("/addgroupStudy")
    public SaResult addgroupStudy(String addgroupStudy) {
        myRedis.setAdd("groupStudy",addgroupStudy);
        return SaResult.ok();
    }
    @GetMapping("/allgroup_talk")
    public SaResult allgroup_talk() {
        Set<String> group_talk = myRedis.setfindAll("group_talk");
        ArrayList<RedisEntity> redisEntities = new ArrayList<>();
        for (String s :  group_talk) {
            RedisEntity redisEntity = new RedisEntity();
            redisEntity.setMessage(s);
            redisEntities.add(redisEntity);
        }
        return SaResult.ok().setData(redisEntities);

    }

    @GetMapping("/deletegroup_talk")
    public SaResult delgroup_talk(String deletegroup_talk) {
        myRedis.setDelete("group_talk",deletegroup_talk);
        return SaResult.ok();
    }
    @GetMapping("/addgroup_talk")
    public SaResult addgroup_talk(String addgroup_talk) {
        myRedis.setAdd("group_talk",addgroup_talk);
        return SaResult.ok();
    }
    @GetMapping("/allmessagedelete")
    public SaResult allmessagedelete() {
        Set<String> messagedelete = myRedis.setfindAll("messagedelete");

        ArrayList<RedisEntity> redisEntities = new ArrayList<>();
        for (String s : messagedelete) {
            RedisEntity redisEntity = new RedisEntity();
            redisEntity.setMessage(s);
            redisEntities.add(redisEntity);
        }
        return SaResult.ok().setData(redisEntities);

    }

    @GetMapping("/deletemessagedelete")
    public SaResult delmessagedelete(String deletemessagedelete) {
        myRedis.setDelete("messagedelete",deletemessagedelete);
        return SaResult.ok();
    }
    @GetMapping("/addmessagedelete")
    public SaResult addmessagedelete(String addmessagedelete) {
        myRedis.setAdd("messagedelete",addmessagedelete);
        return SaResult.ok();
    }
}
