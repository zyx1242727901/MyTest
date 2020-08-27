package com.example.demo.mybatis.config;

/**
 * 多数据源配置
 */
//@Configuration
//@MapperScan(sqlSessionFactoryRef = "db2SqlSessionFactory", basePackages = "com.example.demo.mybatis.mapper2")
public class MybatisConfig2 {

//    @Bean(name = "dataSource2")
//    @ConfigurationProperties(prefix = "spring.datasource.db2")
//    public DataSource dataSource2() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2SqlSessionFactory")
//    public SqlSessionFactory db2SqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper2/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean("db2SqlSessionTemplate")
//    public SqlSessionTemplate db2SqlSessionTemplate(@Qualifier("db2SqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
