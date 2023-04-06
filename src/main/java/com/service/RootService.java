package com.service;

import com.entity.Root;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
public interface RootService extends IService<Root> {
    public boolean createRoot(String name,String password,String permissions);
    public Root loginRoot(String name,String password);
}
