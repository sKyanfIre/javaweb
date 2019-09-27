package com.zzz.sso;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author zzz
 * @description 获取redis连接
 * @date 2019/9/27
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig {
    @Value("${spring.redis.hostname}")
    private String hostname;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public JedisConnectionFactory connectionFactory(){
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(hostname);
        connectionFactory.setPort(port);
        return connectionFactory;
    }
}
