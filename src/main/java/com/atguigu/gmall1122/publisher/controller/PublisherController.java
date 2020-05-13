package com.atguigu.gmall1122.publisher.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.gmall1122.publisher.service.EsService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class PublisherController {

    @Autowired
    EsService esService;

    //@RequestMapping(value = "realtime-total" ,method = RequestMethod.GET)
    @GetMapping("realtime-total")
    public String realtimeTotal(@RequestParam("date") String dt){
        List<Map> totalList=new ArrayList<>();
        HashMap dauMap = new HashMap<>();
        dauMap.put("id","dau");
        dauMap.put("name","新增日活");
        Long dauTotal = esService.getDauTotal(dt);
        dauMap.put("value",dauTotal);

        totalList.add(dauMap);

        HashMap newMidMap = new HashMap<>();
        newMidMap.put("id","dau");
        newMidMap.put("name","新增设备");
        newMidMap.put("value",233);

        totalList.add(newMidMap);

        return JSON.toJSONString(totalList);

    }

    @GetMapping("realtime-hour")
    public String realtimeHour(@RequestParam("id") String id ,@RequestParam("date") String dt ){
        if("dau".equals(id)){
            Map<String,Map> hourMap=new HashMap<>();
            Map dauHourTdMap = esService.getDauHour(dt);
            hourMap.put("today",dauHourTdMap);
            String yd = getYd(dt);
            Map dauHourYdMap = esService.getDauHour(yd);
            hourMap.put("yesterday",dauHourYdMap);
            return JSON.toJSONString(hourMap);
        }
        return null;
    }

    private  String getYd(String td){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String yd=null;
        try {
            Date tdDate = dateFormat.parse(td);
            Date ydDate = DateUtils.addDays(tdDate, -1);
            yd=dateFormat.format(ydDate);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式转变失败");
        }
        return yd;
    }



}
