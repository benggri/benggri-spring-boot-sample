package com.example.spring_boot_sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_sample.entity.Db2Entity;
import com.example.spring_boot_sample.service.Db2Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("db2")
@RequiredArgsConstructor
public class Db2Controller {
    private final Db2Service service;

    @GetMapping("{secondTableIdx}")
    public Mono<ResponseEntity> getDb2(
            @PathVariable(name = "secondTableIdx") Long secondTableIdx) {
        return Mono.just(ResponseEntity.ok().body(service.findById(secondTableIdx)));
    }

    @GetMapping
    public Mono<ResponseEntity> insert(
            @RequestParam(name = "columnName") String columnName,
            @RequestParam(name = "createFirstTableIdx") Long createFirstTableIdx) {
        return Mono.just(ResponseEntity.ok().body(service.insert(Db2Entity.builder()
                .columnName(columnName)
                .createFirstTableIdx(createFirstTableIdx)
                .build())));
    }

}
