package com.itheima.dbsharding.simple.controller;

import com.itheima.dbsharding.simple.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShardingController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/sharding")
    public ResponseEntity<Long> createOrder(){
        orderService.createOrder();
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
