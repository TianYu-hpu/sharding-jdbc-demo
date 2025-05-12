package com.itheima.dbsharding.simple.service;


import com.itheima.dbsharding.simple.client.LeafClient;
import com.itheima.dbsharding.simple.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private LeafClient leafClient;

    public void createOrder() {
        for(int i = 0; i < 10000;i++) {
            Long orderId = Long.parseLong(leafClient.getOrdrId());
            log.info("获取的orderId:{}", orderId);
            orderDao.saveOrder(orderId, new BigDecimal(i), i + 0L, "SUCCESS");
        }
    }


}
