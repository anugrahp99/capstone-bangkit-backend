package com.bangkit.yubisayu.botani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class BotaniApplication {
	public static void main(String[] args) {
		SpringApplication.run(BotaniApplication.class, args);
	}
}
