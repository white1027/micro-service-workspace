package com.example.library.common.service;

import com.example.library.common.model.LombokBuilderUser;
import com.example.library.common.model.RecordUser;
import com.example.library.common.model.LombokUser;

public interface UserService {
    RecordUser getRecordUserByName(String name);
    LombokUser getLombokUserByName(String name);
    LombokBuilderUser getLombokBuilderUserByName(String name);
}
