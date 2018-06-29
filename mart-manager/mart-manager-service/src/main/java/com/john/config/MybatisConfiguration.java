package com.john.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 张彦斌
 * @Date: 2018-06-26 10:45
 */
@Configuration
@MapperScan("com.john.mapper")
public class MybatisConfiguration {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Bean
    public DataSource dataSource() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put("url", url);
        properties.put("username", username);
        properties.put("password", password);
        properties.put("driverClassName", driverClassName);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource;
    }

    /**
     * 加载resource的两种方法
     * 1、使用property.load
     * 2、使用resourceloader，推荐使用这种方法，是spring提供的
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
//        Properties properties = new Properties();
//        properties.load(getClass().getResourceAsStream("mybatis/mybatis-config.xml"));
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("mybatis/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;

    }
}
