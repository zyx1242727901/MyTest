package com.example.demo.mybatis.config;

/**
 * 多数据源配置
 */
//@Configuration
//@MapperScan(sqlSessionFactoryRef = "db1SqlSessionFactory", basePackages = "com.example.demo.mybatis.mapper1")
public class MybatisConfig1 {

//
//    @Bean(name = "dataSource1")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.db1")
//    public DataSource dataSource1() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db1SqlSessionFactory")
//    @Primary
//    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper1/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean("db1SqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}
