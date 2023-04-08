package com.service;

import com.entity.Todayeat;
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
public interface TodayeatService extends IService<Todayeat> {
        public List getAllTodayeat();
        public void deleteTodayeat(String id);

        List selectlike(String message);
}
