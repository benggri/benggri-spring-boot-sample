package com.example.spring_boot_sample.config.r2dbc.repositories;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.example.spring_boot_sample.repository.db_3", entityOperationsRef = "db3R2dbcEntityTemplate")
public class Db3R2dbcRepositoryConfig {

}
