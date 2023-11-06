package com.example.library.common.service;

import com.example.library.common.model.user.UserResponse;
import com.example.library.common.model.user.UserSearchParam;
import com.example.library.common.model.user.domain.User;

import java.util.List;

public interface UserService {
    List<UserResponse> findAllUser();
    List<UserResponse> findUserBySearchParam(UserSearchParam user);
    int createUser(User user);
    UserResponse findById(long id);
    int updateUser(User user);
    int deleteUser(Long id);
}
