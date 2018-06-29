package com.john.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @Author: 张彦斌
 * @Date: 2018-06-26 11:37
 */
@PropertySources({
        @PropertySource("classpath:/jdbc.properties"),
        @PropertySource("classpath:/application.properties")})
@ComponentScan("com.john.config")
public class RootConfig {
}
