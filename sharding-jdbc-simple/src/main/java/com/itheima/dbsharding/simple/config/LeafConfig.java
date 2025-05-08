package com.itheima.dbsharding.simple.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sankuai.inf.leaf.segment.SegmentIDGenImpl;
import com.sankuai.inf.leaf.segment.dao.impl.IDAllocDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class LeafConfig {

    @Value("${leaf.url}")
    private String url;
    @Value("${leaf.username}")
    private String username;
    @Value("${leaf.password}")
    private String password;
    @Value("${leaf.driverClassName}")
    private String driverClassName;

    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.init();
        return dataSource;
    }

    @Bean
    public IDAllocDaoImpl idAllocDao() throws SQLException {
        return new IDAllocDaoImpl(dataSource());
    }

    @Bean
    public SegmentIDGenImpl segmentIDGenImpl() throws SQLException {
        SegmentIDGenImpl segmentIDGen = new SegmentIDGenImpl();
        segmentIDGen.setDao(idAllocDao());
        segmentIDGen.init();
        return segmentIDGen;
    }
}
