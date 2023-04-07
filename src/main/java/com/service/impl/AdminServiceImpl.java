package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.entity.Admin;
import com.mapper.AdminMapper;
import com.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
@Autowired
private AdminMapper adminMapper;

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> admins = adminMapper.selectList(null);
        return admins;
    }

    @Override
    public void updateAdmin(Admin admin) {
        UpdateWrapper<Admin> adminUpdateWrapper = new UpdateWrapper<>();
        adminUpdateWrapper.eq("account",admin.getAccount());
        adminMapper.update(admin,adminUpdateWrapper);
    }

    @Override
    public void delAdmin(Admin admin) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("account",admin.getAccount());
        adminMapper.delete(adminQueryWrapper);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
