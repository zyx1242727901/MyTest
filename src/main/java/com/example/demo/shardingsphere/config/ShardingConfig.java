package com.example.demo.shardingsphere.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ShardingConfig {
//    @Bean
//    public void dataSource(){
//        // Configure actual data sources
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//// Configure the first data source
//        BasicDataSource dataSource1 = new BasicDataSource();
//        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource1.setUrl("jdbc:mysql://localhost:3306/ds0");
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("");
//        dataSourceMap.put("ds0", dataSource1);
//
//// Configure the second data source
//        BasicDataSource dataSource2 = new BasicDataSource();
//        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource2.setUrl("jdbc:mysql://localhost:3306/ds1");
//        dataSource2.setUsername("root");
//        dataSource2.setPassword("");
//        dataSourceMap.put("ds1", dataSource2);
//
//// Configure order table rule
//        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_order", "ds${0..1}.t_order${0..1}");
//
//// Configure database sharding strategy
//        orderTableRuleConfig.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("user_id", "dbShardingAlgorithm"));
//
//// Configure table sharding strategy
//        orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("order_id", "tableShardingAlgorithm"));
//
//// Omit t_order_item table rule configuration ...
//// ...
//
//// Configure sharding rule
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTables().add(orderTableRuleConfig);
//
//// Configure database sharding algorithm
//        Properties dbShardingAlgorithmrProps = new Properties();
//        dbShardingAlgorithmrProps.setProperty("algorithm.expression", "ds${user_id % 2}");
//        shardingRuleConfig.getShardingAlgorithms().put("dbShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", dbShardingAlgorithmrProps));
//
//// Configure table sharding algorithm
//        Properties tableShardingAlgorithmrProps = new Properties();
//        tableShardingAlgorithmrProps.setProperty("algorithm.expression", "t_order${order_id % 2}");
//        shardingRuleConfig.getShardingAlgorithms().put("tableShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tableShardingAlgorithmrProps));
//
//// Create ShardingSphereDataSource
//        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singleton((shardingRuleConfig), new Properties());
//    }
}
