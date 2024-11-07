package com.example.spring_boot_sample.repository.db_1;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.spring_boot_sample.entity.Db1Entity;

import reactor.core.publisher.Mono;

public interface Db1Repository extends ReactiveCrudRepository<Db1Entity, Long> {

    Mono<Db1Entity> findByColumnName(String columnName);

}
