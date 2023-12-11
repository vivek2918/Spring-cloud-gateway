package com.zomato.zomatogateway1.filter;

import com.zomato.zomatogateway1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {


    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {

        return ((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){

                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("missing authorization header");
                }

                String token = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(token != null && token.startsWith("Bearer ")){
                    token = token.substring(7);
                }

                try{
                    jwtUtil.validateToken(token);
                }
                catch (Exception e){
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }


    public static class Config {

    }
}
