package com.john.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:jdbc.properties")
public class MybatisConfiguration implements EnvironmentAware {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;


    private Environment environment;

    @Bean
    public DataSource dataSource() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put("url", environment.getProperty("jdbc.url"));
        properties.put("username", environment.getProperty("jdbc.username"));
        properties.put("password", environment.getProperty("jdbc.password"));
        properties.put("driverClassName", environment.getProperty("jdbc.driverClassName"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource;
    }

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
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.john.mapper");
        return mapperScannerConfigurer;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;

    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
