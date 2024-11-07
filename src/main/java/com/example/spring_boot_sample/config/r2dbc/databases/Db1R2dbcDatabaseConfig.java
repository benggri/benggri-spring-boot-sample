package com.example.spring_boot_sample.config.r2dbc.databases;

import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;

import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Db1R2dbcDatabaseConfig {

    // Primary 데이터베이스 설정
    @Bean
    @Primary
    @ConfigurationProperties("spring.r2dbc.databases.datasource1")
    public R2dbcProperties db1R2dbcProperties() {
        return new R2dbcProperties();
    }

    @Bean
    @Primary
    public ConnectionFactory db1ConnectionFactory(@Qualifier("db1R2dbcProperties") R2dbcProperties db1R2dbcProperties) {
        return createConnectionFactory(db1R2dbcProperties);
    }

    // DatabaseClient 설정
    @Bean
    public DatabaseClient db1DatabaseClient(
            @Qualifier("db1ConnectionFactory") ConnectionFactory db1ConnectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(db1ConnectionFactory)
                .build();
    }

    @Bean
    public R2dbcEntityTemplate db1R2dbcEntityTemplate(
            @Qualifier("db1ConnectionFactory") ConnectionFactory db1ConnectionFactory) {
        return new R2dbcEntityTemplate(db1ConnectionFactory);
    }

    private ConnectionFactory createConnectionFactory(R2dbcProperties properties) {
        log.info("properties.getUrl() : {}", properties.getUrl());
        return ConnectionFactoryBuilder.withOptions(
                ConnectionFactoryOptions.parse(properties.getUrl())
                        .mutate()
                        .option(USER, properties.getUsername())
                        .option(PASSWORD, properties.getPassword()))
                .build();
    }
}
