package com.example.core.gateway.controller;

import com.example.library.common.model.RecordUser;
import com.example.library.common.model.domain.User;
import com.example.library.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @DubboReference
    private UserService userService;

    @GetMapping
    public Mono<List<RecordUser>> findUserBySearchParam(@ParameterObject User user) {
        return Mono.just(userService.findUserBySearchParam(user));
    }

    @GetMapping("/{id}")
    public Mono<RecordUser> findUserById(@PathVariable Long id) {
        return Mono.just(userService.findRecordUserById(id));
    }

    @PostMapping
    public Mono<Integer> createUser(@RequestBody User user) {
        return Mono.just(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public Mono<Integer> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return Mono.just(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public Mono<Integer> deleteUser(@PathVariable Long id) {
        return Mono.just(userService.deleteUser(id));
    }
}
