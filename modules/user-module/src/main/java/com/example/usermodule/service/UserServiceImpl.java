package com.example.usermodule.service;

import com.example.library.common.model.LombokBuilderUser;
import com.example.library.common.model.LombokUser;
import com.example.library.common.model.RecordUser;
import com.example.library.common.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public RecordUser getRecordUserByName(String name) {
        return new RecordUser(name, 18);
    }

    @Override
    public LombokUser getLombokUserByName(String name) {
        var r = new LombokUser();
        r.setName(name);
        r.setAge(18);
        return r;
    }

    @Override
    public LombokBuilderUser getLombokBuilderUserByName(String name) {
        return LombokBuilderUser.builder().name(name).age(18).build();
    }
}
