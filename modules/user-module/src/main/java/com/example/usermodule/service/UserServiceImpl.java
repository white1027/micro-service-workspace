package com.example.usermodule.service;

import com.example.library.common.model.LombokBuilderUser;
import com.example.library.common.model.LombokUser;
import com.example.library.common.model.RecordUser;
import com.example.library.common.model.domain.User;
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
    public RecordUser findRecordUserById(long id) {
        return userMapper.findRecordUserById(id);
    }

    @Override
    public LombokUser findLombokUserById(long id) {
        return userMapper.findLombokUserById(id);
    }

    @Override
    public LombokBuilderUser findLombokBuilderUserById(long id) {
        return userMapper.findLombokBuilderUserById(id);
    }

    @Override
    public User createUser(User user) {
        user.setId(snowflakeDistributeId.nextId());
        userMapper.insert(user);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<User> findUserBySearchParam(User user) {
        return userMapper.findUserBySearchParam(user);
    }
}
