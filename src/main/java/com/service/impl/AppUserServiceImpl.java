package com.service.impl;

import com.entity.AppUser;
import com.mapper.AppUserMapper;
import com.service.AppUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
