package com.service;

import com.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
public interface AdminService extends IService<Admin> {

public List<Admin> getAllAdmin();

public void updateAdmin(Admin admin);

public void delAdmin(Admin admin);

public void addAdmin(Admin admin);

}
