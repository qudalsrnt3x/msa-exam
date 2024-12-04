package com.sparta.msa_exam.gateway.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductLoadBalancerConfig {

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(ConfigurableApplicationContext context) {
        return ServiceInstanceListSupplier.builder()
                .withDiscoveryClient() // Eureka에서 서비스 인스턴스 조회
                .withWeighted(instance -> { // 가중치 기반 로드 밸런싱을 활성화
                    return instance.getPort() == 19093 ? 70 : 30;
                })
                .withCaching() // 결과 캐싱
                .build(context);
    }

}
