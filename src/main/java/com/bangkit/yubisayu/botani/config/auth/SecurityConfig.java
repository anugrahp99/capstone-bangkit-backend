package com.bangkit.yubisayu.botani.config.auth;

import com.bangkit.yubisayu.botani.component.AuthenticationManager;
import com.bangkit.yubisayu.botani.component.SecurityContextRepository;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/24/2021 10:18 PM
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    private static final String[] SWAGGER_LIST = {
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources",
            "/configuration/security",
            "/webjars/**",
            "/swagger-resources/**",
            "/swagger-ui.html"
    };

    private static final String[] AUTH_LIST = {
            ApiPath.USER_SIGN_IN,
            ApiPath.USER_SIGN_UP
    };

    private static final String[] ALL_API = {
            ApiPath.USERS,
            ApiPath.USERS + "/*",
    };

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .cors()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .exceptionHandling()
                .authenticationEntryPoint((serverWebExchange, e) ->
                        Mono.fromRunnable(() ->
                                serverWebExchange
                                        .getResponse()
                                        .setStatusCode(HttpStatus.UNAUTHORIZED)
                        ))
                .accessDeniedHandler((serverWebExchange, e) ->
                        Mono.fromRunnable(() ->
                                serverWebExchange
                                        .getResponse()
                                        .setStatusCode(HttpStatus.FORBIDDEN)
                        ))
                .and()
                .authenticationManager(authenticationManager)
                .securityContextRepository(securityContextRepository)
                .headers().frameOptions().disable()
                .and()
                .authorizeExchange()
                .pathMatchers(SWAGGER_LIST).permitAll()
                .pathMatchers("/**").permitAll()
                .pathMatchers("/",
                        "/*/*.png",
                        "/*/*.gif",
                        "/*/*.svg",
                        "/*/*.jpeg").permitAll()
                .anyExchange().authenticated()
                .and().build();
    }
}