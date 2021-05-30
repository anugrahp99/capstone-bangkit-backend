package com.bangkit.yubisayu.botani.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.ReactiveAuditorAware;
import reactor.core.publisher.Mono;

public class PostgresAuditorAwareConfiguration {

    @Bean
    ReactiveAuditorAware<String> auditorAware() {
        return () -> Mono.just("AUDITOR");
    }

}
