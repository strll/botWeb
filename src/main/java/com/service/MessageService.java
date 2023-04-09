package com.service;

import com.entity.Message;
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
public interface MessageService extends IService<Message> {
    public List getallMessage();
    public void delectMessage(String id,String url);
    public List getlikeMessage(String value);
}
