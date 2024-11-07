package com.example.spring_boot_sample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_sample.entity.Db3Entity;
import com.example.spring_boot_sample.service.Db3Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("third")
@RequiredArgsConstructor
public class Db3Controller {
    private final Db3Service service;

    @GetMapping("{thirdTableIdx}")
    public Mono<ResponseEntity> getForum(
            @PathVariable(name = "thirdTableIdx") Long thirdTableIdx) {
        return Mono.just(ResponseEntity.ok().body(service.findById(thirdTableIdx)));
    }

    @GetMapping
    public Mono<ResponseEntity> insert(
            @RequestParam(name = "columnName") String columnName,
            @RequestParam(name = "createFirstTableIdx") Long createFirstTableIdx) {
        return Mono.just(ResponseEntity.ok().body(service.insert(Db3Entity.builder()
                .columnName(columnName)
                .createFirstTableIdx(createFirstTableIdx)
                .build())));
    }

}
