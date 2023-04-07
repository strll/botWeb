package com.service;

import com.entity.AppUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.WebEntity.userPage;

/**
 * <p>
 * app端的用户表 服务类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
public interface AppUserService extends IService<AppUser> {
    public userPage getAppUser();

}
