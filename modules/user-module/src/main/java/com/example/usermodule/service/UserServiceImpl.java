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
    public List<RecordUser> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<RecordUser> findUserBySearchParam(User user) {
        return userMapper.findUserBySearchParam(user);
    }
}
