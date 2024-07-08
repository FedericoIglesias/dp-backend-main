package dhm.gateway.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class CustomFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpServletRequest request = (HttpServletRequest) exchange.getRequest();
        final String token = String.valueOf(request.getHeaders(AUTHORIZATION));
        System.out.println(token);
        return null;
    }
}
