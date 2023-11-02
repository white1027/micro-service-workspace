package com.example.library.common.service;

import com.example.library.common.model.LombokBuilderUser;
import com.example.library.common.model.RecordUser;
import com.example.library.common.model.LombokUser;
import com.example.library.common.model.domain.User;

import java.util.List;

public interface UserService {
    RecordUser findRecordUserById(long id);
    LombokUser findLombokUserById(long id);
    LombokBuilderUser findLombokBuilderUserById(long id);
    List<RecordUser> findAllUser();
    List<RecordUser> findUserBySearchParam(User user);
    int createUser(User user);
    int updateUser(User user);
    int deleteUser(Long id);
}
