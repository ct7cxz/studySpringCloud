package com.ct.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("gateway-route-1",    //路由名称，随便取，但是具体开发环境起的名称应该有意义
                r -> r.path("/cloudGateWay").       //配置本地访问路径
                        uri("https://spring.io/projects/spring-cloud-gateway")).    //配置远程代理页面
                build();
    }
}
