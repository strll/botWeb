package com.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.AppUser;
import com.entity.userPage;
import com.mapper.AppUserMapper;
import com.service.AppUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * app端的用户表 服务实现类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {
@Autowired
    AppUserMapper appUserMapper;

public userPage getAppUser(){


    QueryWrapper<AppUser> appUserQueryWrapper = new QueryWrapper<>();
    List<AppUser> appUsers = appUserMapper.selectList(appUserQueryWrapper);

    userPage userPage = new userPage();
    userPage.setAppUserList(appUsers);
    userPage.setAppUserlength(appUsers.size()+"");
    return  userPage;
}


}


