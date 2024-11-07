package com.example.spring_boot_sample.config.r2dbc.databases;

import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Db3R2dbcDatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.r2dbc.databases.datasource3")
    public R2dbcProperties db3R2dbcProperties() {
        return new R2dbcProperties();
    }

    @Bean
    public ConnectionFactory db3ConnectionFactory(@Qualifier("db3R2dbcProperties") R2dbcProperties db3R2dbcProperties) {
        return createConnectionFactory(db3R2dbcProperties);
    }

    @Bean
    public DatabaseClient db3DatabaseClient(
            @Qualifier("db3ConnectionFactory") ConnectionFactory db3ConnectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(db3ConnectionFactory)
                .build();
    }

    @Bean
    public R2dbcEntityTemplate db3R2dbcEntityTemplate(
            @Qualifier("db3ConnectionFactory") ConnectionFactory db3ConnectionFactory) {
        return new R2dbcEntityTemplate(db3ConnectionFactory);
    }

    private ConnectionFactory createConnectionFactory(R2dbcProperties db3R2dbcProperties) {
        log.info("properties.getUrl() : {}", db3R2dbcProperties.getUrl());
        return ConnectionFactoryBuilder.withOptions(
                ConnectionFactoryOptions.parse(db3R2dbcProperties.getUrl())
                        .mutate()
                        .option(USER, db3R2dbcProperties.getUsername())
                        .option(PASSWORD, db3R2dbcProperties.getPassword()))
                .build();
    }
}
