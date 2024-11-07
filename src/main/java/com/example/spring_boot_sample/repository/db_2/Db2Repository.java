package com.example.spring_boot_sample.repository.db_2;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.spring_boot_sample.entity.Db2Entity;

import reactor.core.publisher.Mono;

public interface Db2Repository extends ReactiveCrudRepository<Db2Entity, Long> {

    Mono<Db2Entity> findByColumnName(String columnName);

}
