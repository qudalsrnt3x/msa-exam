package com.sparta.msa_exam.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;


@Component
public class ServerPortHeaderFilter implements GlobalFilter, Ordered {

    private static final String SERVER_PORT_HEADERS_NAME = "Server-Port";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            URI uri = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
            if (uri != null) {
                HttpHeaders headers = exchange.getResponse().getHeaders();
                headers.add(SERVER_PORT_HEADERS_NAME, String.valueOf(uri.getPort()));
            }
        }));
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }

}
