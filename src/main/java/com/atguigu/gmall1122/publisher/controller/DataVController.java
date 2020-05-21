package com.atguigu.gmall1122.publisher.controller;


import com.alibaba.fastjson.JSON;
import com.atguigu.gmall1122.publisher.bean.UserInfo;
import com.atguigu.gmall1122.publisher.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DataVController {

    //路径和参数随便定 ，但是返回值要看datav的需要
    @Autowired
    MysqlService mysqlService;

    @GetMapping("trademark-sum")
    public String trademarkSum(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate){
         if(startDate.length()==0||  endDate.length()==0){
                return "参数不能为空！";
         }
        startDate = startDate.replace("_", " ");
        endDate = endDate.replace("_", " ");
        List<Map> trademarkSumList = mysqlService.getTrademarkSum(startDate, endDate);

        //根据datav调整结构
        List<Map>  datavVList=new ArrayList<>();
        for (Map trademarkSumMap : trademarkSumList) {
           Map dataVMap=  new HashMap();

            dataVMap.put("x",trademarkSumMap.get("tm_name")) ;
            dataVMap.put("y",trademarkSumMap.get("amount")) ;
            dataVMap.put("s","1") ;
            datavVList.add(dataVMap);
        }
        UserInfo userInfo = new UserInfo("1001","zhang3");


        return JSON.toJSONString(datavVList) ;


    }





}
