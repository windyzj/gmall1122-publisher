package com.atguigu.gmall1122.publisher.service.impl;

import com.atguigu.gmall1122.publisher.mapper.TrademarkAmountSumMapper;
import com.atguigu.gmall1122.publisher.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MysqlServiceImpl implements MysqlService {

    @Autowired
    TrademarkAmountSumMapper trademarkAmountSumMapper;

    @Override
    public List<Map> getTrademardSum(String startDate, String endDate) {
        return trademarkAmountSumMapper.selectTradeSum(startDate,endDate);
    }
}
