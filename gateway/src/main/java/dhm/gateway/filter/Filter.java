package dhm.gateway.filter;

import dhm.gateway.repository.IFeignJwtRepository;
import dhm.gateway.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class Filter implements GlobalFilter{


    private final JwtService serviJwt;
    @Autowired
    public Filter(JwtService jwtService) {
        this.serviJwt = jwtService;
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
             throw new RuntimeException("Missing authorization header");
        }

        String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0).substring(7);

        if(!serviJwt.validateToken(token)){
            throw new RuntimeException("Token invalidate");
        }

        String id = serviJwt.getIdFromToken(token);

        System.out.println(id);
        exchange.getRequest().getHeaders().add("id",id);

        return chain.filter(exchange);
    }
}
