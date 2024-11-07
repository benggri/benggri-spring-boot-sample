package com.example.spring_boot_sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_sample.entity.Db1Entity;
import com.example.spring_boot_sample.service.Db1Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("db1")
@RequiredArgsConstructor
public class Db1Controller {
    private final Db1Service service;

    @GetMapping("{firstTableIdx}")
    public Mono<ResponseEntity> getDb1(
            @PathVariable(name = "firstTableIdx") Long firstTableIdx) {
        return Mono.just(ResponseEntity.ok().body(service.findById(firstTableIdx)));
    }

    @GetMapping
    public Mono<ResponseEntity> insert(
            @RequestParam(name = "columnName") String columnName,
            @RequestParam(name = "nickName") String nickName) {
        return Mono.just(ResponseEntity.ok().body(service.insert(Db1Entity.builder()
                .columnName(columnName)
                .nickName(nickName)
                .build())));
    }

}
