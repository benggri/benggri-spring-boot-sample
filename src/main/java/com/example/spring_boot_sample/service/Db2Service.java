package com.example.spring_boot_sample.service;

import org.springframework.stereotype.Service;

import com.example.spring_boot_sample.entity.Db2Entity;
import com.example.spring_boot_sample.repository.db_2.Db2Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class Db2Service {
    private final Db2Repository repository;
    private final Db1Service db1Service;

    public Mono<Db2Entity> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Db2Entity> findByColumnName(String columnName) {
        return repository.findByColumnName(columnName);
    }

    public Mono<Db2Entity> insert(Db2Entity entity) {
        log.info("Db2Entity : {}", entity);
        // validate createFirstTableIdx
        Mono db1Check = db1Service.findById(entity.getCreateFirstTableIdx())
                .flatMap(db1 -> Mono.just(db1)) // if findById successfully return a value, it should return value
                .switchIfEmpty(Mono.defer(() -> {
                    log.error("createFirstTableIdx is not exist : {} :", entity.getCreateFirstTableIdx());
                    return Mono.error(new RuntimeException("not found data"));
                }));

        return Mono.when(db1Check)
                .then(Mono.defer(() -> {
                    log.info("entity : {}", entity);
                    return repository.save(entity);
                }))
                .doOnError((error) -> {
                    error.printStackTrace();
                    throw new RuntimeException(error);
                });
    }

    public Mono<Db2Entity> update(Db2Entity entity) {
        return repository.save(entity).doOnError((error) -> {
            error.printStackTrace();
            throw new RuntimeException(error);
        });
    }

    public Mono<Db2Entity> deleteById(Db2Entity entity) {
        repository.deleteById(entity.getSecondTableIdx()).doOnError((error) -> {
            error.printStackTrace();
            throw new RuntimeException(error);
        });
        return Mono.just(entity);
    }

}
