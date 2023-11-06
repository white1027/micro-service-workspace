package com.example.usermodule.service;

import com.example.library.common.model.user.UserResponse;
import com.example.library.common.model.user.UserSearchParam;
import com.example.library.common.model.user.domain.User;
import com.example.library.common.service.UserService;
import com.example.library.common.utils.SnowflakeDistributeId;
import com.example.usermodule.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.List;

@DubboService
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final SnowflakeDistributeId snowflakeDistributeId;

    UserServiceImpl(UserMapper userMapper, SnowflakeDistributeId snowflakeDistributeId) {
        this.userMapper = userMapper;
        this.snowflakeDistributeId = snowflakeDistributeId;
    }

    @Override
    public UserResponse findById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public int createUser(User user) {
        user.setId(snowflakeDistributeId.nextId());
        return userMapper.createUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List<UserResponse> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<UserResponse> findUserBySearchParam(UserSearchParam user) {
        return userMapper.findUserBySearchParam(user);
    }
}
