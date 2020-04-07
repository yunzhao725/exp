package com.exp.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ylzhao
 * @create 2020/4/5-17:16
 * 等同于 applicationContext.xml 中 <bean id="" class=""> 做DI
 *
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启负载均衡 http://CLOUD-PAYMENT-SERVICE 负载8001 或 8002
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
