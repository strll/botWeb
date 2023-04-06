package com.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Root;
import com.mapper.RootMapper;
import com.service.RootService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@Service
public class RootServiceImpl extends ServiceImpl<RootMapper, Root> implements RootService {
@Autowired
    private RootMapper rootMapper;

@Override
  public boolean createRoot(String name,String password,String permissions){
      String s = SecureUtil.md5(password);
      Root root = new Root();
      root.setPassword(s);
      root.setAccount(name);
      if (  !StrUtil.isEmpty(permissions)){
          root.setPermissions(permissions);
      }
      int insert = rootMapper.insert(root);
      if (insert==0){
          return false;
      }else {
          return true;
      }
  }

    @Override
    public Root loginRoot(String name, String password) {
        String s = SecureUtil.md5(password);
        QueryWrapper<Root> rootQueryWrapper = new QueryWrapper<>();
        rootQueryWrapper.eq("account",name);
        rootQueryWrapper.eq("password",s);
        Root root = rootMapper.selectOne(rootQueryWrapper);
        return root;
    }
}
