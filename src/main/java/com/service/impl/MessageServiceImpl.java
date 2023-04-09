package com.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Message;
import com.mapper.MessageMapper;
import com.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.utils.Send_To_minio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

    @Autowired
    private MessageMapper mapper;
@Autowired
private Send_To_minio send_to_minio;

    @Override
    public List getallMessage() {
        List<Message> messages = mapper.selectList(null);
        ArrayList<Message> relist= new ArrayList<>();
        for (Message message : messages) {
            Integer id = message.getId();
            String keymessage = message.getKeymessage();
            String url = message.getUrl();
            String qq = message.getQq();
            String valuemessage = message.getValuemessage();
            if (!StrUtil.isEmpty(url)){
                Message message1 = new Message();
                message1.setId(id);
                message1.setQq(qq);
                message1.setKeymessage(keymessage);
                message1.setUrl(url);
                relist.add(message1);
            }else {
                relist.add(message);
            }


        }

        return relist;
    }

    @Override
    public void delectMessage(String id,String url) {
        if (!StrUtil.isEmpty(url)){
            send_to_minio.Send_To_minio_Delete(url);
        }

        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.eq("id",id);
        mapper.delete(messageQueryWrapper);
    }

    @Override
    public List getlikeMessage(String value) {
        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.like("keymessage",value);
        List<Message> messages = mapper.selectList(messageQueryWrapper);

        ArrayList<Message> relist= new ArrayList<>();
        for (Message message : messages) {
            Integer id = message.getId();
            String keymessage = message.getKeymessage();
            String url = message.getUrl();
            String qq = message.getQq();
            String valuemessage = message.getValuemessage();
            if (!StrUtil.isEmpty(url)){
                Message message1 = new Message();
                message1.setId(id);
                message1.setQq(qq);
                message1.setKeymessage(keymessage);
                message1.setUrl(url);
                relist.add(message1);
            }else {
                relist.add(message);
            }


        }

        return relist;
    }
}
