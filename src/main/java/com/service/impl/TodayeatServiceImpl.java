package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entity.Todayeat;
import com.entity.WebEntity.WebTodayEat;
import com.mapper.TodayeatMapper;
import com.service.TodayeatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.utils.Send_To_minio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wxt
 * @since 2023-04-05
 */
@Service
public class TodayeatServiceImpl extends ServiceImpl<TodayeatMapper, Todayeat> implements TodayeatService {

    @Autowired
    private TodayeatMapper todayeatMapper;

    @Autowired
    private Send_To_minio send_to_minio;

    @Override
    public List<WebTodayEat> getAllTodayeat() {

        List<Todayeat> todayeats = todayeatMapper.selectList(null);
        ArrayList<WebTodayEat> webTodayEats = new ArrayList<>();

        for (Todayeat todayeat : todayeats) {
            Integer id = todayeat.getId();
            String message = todayeat.getMessage();
            String qq = todayeat.getQq();


            String pattern = "https?://[^\\s]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(message);
            String[] split = message.split("\\[");
            String messagetext= split[0];
            String image ="";
            if(m.find()){
                String group = m.group();
                image = group.replaceAll("]", "");
            }
            WebTodayEat webTodayEat = new WebTodayEat();
            webTodayEat.setId(id);
            webTodayEat.setMessage(messagetext);
            webTodayEat.setUrl(image);
            webTodayEat.setQq(qq);
            webTodayEats.add(webTodayEat);
        }
        return webTodayEats;
    }

    @Override
    public void deleteTodayeat(String id) {
        QueryWrapper<Todayeat> todayeatQueryWrapper = new QueryWrapper<>();
        todayeatQueryWrapper.eq("id",id);
        Todayeat todayeat = todayeatMapper.selectOne(todayeatQueryWrapper);
        String message = todayeat.getMessage();
try {
    String pattern = "https?://[^\\s]+";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(message);
    String[] split = message.split("\n");
    String messagetext= split[0];
    String image ="";
    if(m.find()){
        String group = m.group();
        image = group.replaceAll("]", "");
    }
    send_to_minio.Send_To_minio_Delete(image);
}catch (Exception e){

}
        todayeatMapper.delete(todayeatQueryWrapper);
    }

    @Override
    public List<WebTodayEat> selectlike(String message) {
        QueryWrapper<Todayeat> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.like("message",message);
        List<Todayeat> todayeats = todayeatMapper.selectList(objectQueryWrapper);
        ArrayList<WebTodayEat> arraywebTodayEats = new ArrayList<>();
        for (Todayeat todayeat : todayeats) {
            Integer id = todayeat.getId();
            String message1 = todayeat.getMessage();
            String qq = todayeat.getQq();
            String pattern = "https?://[^\\s]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(message1);
            String[] split = message1.split("\\[");
            String messagetext= split[0];
            String image ="";
            if(m.find()){
                String group = m.group();
                image = group.replaceAll("]", "");
            }
            WebTodayEat webTodayEat = new WebTodayEat();
            webTodayEat.setId(id);
            webTodayEat.setMessage(messagetext);
            webTodayEat.setUrl(image);
            webTodayEat.setQq(qq);
            arraywebTodayEats.add(webTodayEat);
        }

        return arraywebTodayEats;
    }
}
