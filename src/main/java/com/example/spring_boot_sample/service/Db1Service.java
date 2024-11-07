package com.example.spring_boot_sample.service;

import org.springframework.stereotype.Service;

import com.example.spring_boot_sample.entity.Db1Entity;
import com.example.spring_boot_sample.repository.db_1.Db1Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class Db1Service {
    private final Db1Repository repository;

    public Mono<Db1Entity> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Db1Entity> findByColumnName(String columnName) {
        return repository.findByColumnName(columnName);
    }

    public Mono<Db1Entity> insert(Db1Entity entity) {
        return repository.save(entity).doOnError((error) -> {
            error.printStackTrace();
            throw new RuntimeException(error);
        });
    }

    public Mono<Db1Entity> update(Db1Entity entity) {
        return repository.save(entity).doOnError((error) -> {
            error.printStackTrace();
            throw new RuntimeException(error);
        });
    }

    public Mono<Db1Entity> deleteById(Db1Entity entity) {
        repository.deleteById(entity.getFirstTableIdx()).doOnError((error) -> {
            error.printStackTrace();
            throw new RuntimeException(error);
        });
        return Mono.just(entity);
    }

}