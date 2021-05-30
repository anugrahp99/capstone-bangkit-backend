package com.bangkit.yubisayu.botani.config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 8:18 AM
 */
@Configuration
@EnableR2dbcRepositories
@EnableR2dbcAuditing
public class DatabaseConfig extends AbstractR2dbcConfiguration {
    @Value("${app.cloud.dbname}")
    private String dbName;

    @Value("${app.cloud.dbuser}")
    private String dbUser;

    @Value("${app.cloud.connectionname}")
    private String connectionName;

    @Value("${app.cloud.dbpassword}")
    private String dbPassword;


    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        String connectionString = "r2dbc:gcp:postgres://"+dbUser+":"+dbPassword+"@"+connectionName+"/"+dbName;
        ConnectionFactory connectionFactory = ConnectionFactories.get(connectionString);
        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration
                .builder(connectionFactory)
                .maxIdleTime(Duration.ofMillis(10000))
                .maxSize(20)
                .build();
        return new ConnectionPool(configuration);
    }
}
