package com.zzz.springsession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 *session过期时间1800s
 *
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {
    @Value("${redis.port:6379}")
    private int port;
    @Value("${redis.hostname:localhost}")
    private String hostName;
    @Value("${redis.password}")
    private String password;

    @Bean
    public JedisConnectionFactory connectionFactory(){
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setHostName(hostName);
        connection.setPort(port);
        connection.setPassword(password);
        return connection;

    }}
