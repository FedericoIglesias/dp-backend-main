package dhm.gateway.filter;

import dhm.gateway.repository.IFeignJwtReppsitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class Filter implements GlobalFilter{

    @Autowired
    IFeignJwtReppsitory feigJwt;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
            throw new RuntimeException("Missing authorization header");
        }

        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);

        if(!feigJwt.validateToken(token)){
            throw new RuntimeException("Token invalidate");
        };

        String id = feigJwt.getIdFromToken(token);

        exchange.getRequest().getHeaders().add("id",id);

        return chain.filter(exchange);
    }



}
