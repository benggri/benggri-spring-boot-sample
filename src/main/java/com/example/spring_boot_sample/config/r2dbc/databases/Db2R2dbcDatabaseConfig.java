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
public class Db2R2dbcDatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.r2dbc.databases.datasource2")
    public R2dbcProperties db2R2dbcProperties() {
        return new R2dbcProperties();
    }

    @Bean
    public ConnectionFactory db2ConnectionFactory(@Qualifier("db2R2dbcProperties") R2dbcProperties db2R2dbcProperties) {
        return createConnectionFactory(db2R2dbcProperties);
    }

    @Bean
    public DatabaseClient db2DatabaseClient(
            @Qualifier("db2ConnectionFactory") ConnectionFactory db2ConnectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(db2ConnectionFactory)
                .build();
    }

    @Bean
    public R2dbcEntityTemplate db2R2dbcEntityTemplate(
            @Qualifier("db2ConnectionFactory") ConnectionFactory db2ConnectionFactory) {
        return new R2dbcEntityTemplate(db2ConnectionFactory);
    }

    private ConnectionFactory createConnectionFactory(R2dbcProperties db2R2dbcProperties) {
        log.info("properties.getUrl() : {}", db2R2dbcProperties.getUrl());
        return ConnectionFactoryBuilder.withOptions(
                ConnectionFactoryOptions.parse(db2R2dbcProperties.getUrl())
                        .mutate()
                        .option(USER, db2R2dbcProperties.getUsername())
                        .option(PASSWORD, db2R2dbcProperties.getPassword()))
                .build();
    }
}
