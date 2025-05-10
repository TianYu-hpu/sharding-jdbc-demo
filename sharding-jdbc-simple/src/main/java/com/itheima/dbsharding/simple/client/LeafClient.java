package com.itheima.dbsharding.simple.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 虎哥
 */
@FeignClient("leaf-server")
public interface LeafClient {

    @GetMapping("/api/segment/get/order_id")
    String getOrdrId();
}
