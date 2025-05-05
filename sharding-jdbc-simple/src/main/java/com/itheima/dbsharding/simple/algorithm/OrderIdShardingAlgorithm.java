package com.itheima.dbsharding.simple.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class OrderIdShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        Long orderId = preciseShardingValue.getValue();
        orderId += ThreadLocalRandom.current().nextInt(8);
        String logicTableName = preciseShardingValue.getLogicTableName();
        // 计算分表后缀（如取模分片）
        String tableSuffix = "_" + (orderId % 8);
        return collection.stream()
                .filter(table -> table.endsWith(tableSuffix))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("路由失败"));
    }
}
