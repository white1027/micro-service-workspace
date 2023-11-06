package com.example.core.gateway.controller;

import com.example.library.common.model.user.UserResponse;
import com.example.library.common.model.user.UserSearchParam;
import com.example.library.common.model.user.domain.User;
import com.example.library.common.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Tag(name = "Users API")
@RestController
@RequestMapping("user")
public class UserController {
    @DubboReference
    private UserService userService;

    @Operation(summary = "Find the users by search parameter")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    @GetMapping
    public Mono<List<UserResponse>> findUserBySearchParam(@ParameterObject UserSearchParam user) {
        return Mono.just(userService.findUserBySearchParam(user));
    }

    @Operation(summary = "Find user by user id")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    @GetMapping("/{id}")
    public Mono<UserResponse> findUserById(@Parameter(description = "User id", name = "id") @PathVariable Long id) {
        return Mono.just(userService.findById(id));
    }

    @Operation(summary = "Create user")
    @ApiResponse(responseCode = "200", description = "Successfully created")
    @PostMapping
    public Mono<Integer> createUser(@RequestBody User user) {
        return Mono.just(userService.createUser(user));
    }

    @Operation(summary = "Update user by user id")
    @ApiResponse(responseCode = "200", description = "Successfully updated")
    @PutMapping("/{id}")
    public Mono<Integer> updateUser(@Parameter(description = "User id", name = "id") @PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return Mono.just(userService.updateUser(user));
    }

    @Operation(summary = "Delete user by user id")
    @ApiResponse(responseCode = "200", description = "Successfully deleted")
    @DeleteMapping("/{id}")
    public Mono<Integer> deleteUser(@Parameter(description = "User id", name = "id") @PathVariable Long id) {
        return Mono.just(userService.deleteUser(id));
    }
}
