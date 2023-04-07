package com.service.impl;

import com.entity.Todayeat;
import com.entity.WebEntity.WebTodayEat;
import com.mapper.TodayeatMapper;
import com.service.TodayeatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
            String[] split = message.split("\n");
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
}
