package com.example.spring_boot_sample.repository.db_3;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.spring_boot_sample.entity.Db3Entity;

import reactor.core.publisher.Mono;

public interface Db3Repository extends ReactiveCrudRepository<Db3Entity, Long> {

    Mono<Db3Entity> findByColumnName(String columnName);

}
