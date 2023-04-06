package com.config.sa_token_config;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Root;
import com.mapper.RootMapper;
import com.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    private RootMapper rootMapper;
    /*
    *  返回一个账号所拥有的权限码集合
    * */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        QueryWrapper<Root> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("id",(String)loginId);
        Root root = rootMapper.selectOne(objectQueryWrapper);
        String permissions = root.getPermissions();
        List<String> list = new ArrayList<String>();
        list.add(permissions);
        return list;

    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        QueryWrapper<Root> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("id",(String)loginId);
        Root root = rootMapper.selectOne(objectQueryWrapper);
        String permissions = root.getPermissions();
        List<String> list = new ArrayList<String>();
        list.add(permissions);
        return list;
    }
}
