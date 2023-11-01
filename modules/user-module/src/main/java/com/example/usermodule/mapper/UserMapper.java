package com.example.usermodule.mapper;

import com.example.library.common.model.LombokBuilderUser;
import com.example.library.common.model.LombokUser;
import com.example.library.common.model.RecordUser;
import com.example.library.common.model.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO tbl_user (id, name, age ) VALUES(#{id}, #{name}, #{age})")
    void insert(User user);

    @Select("SELECT id, name, age FROM tbl_user WHERE id = #{id}")
    User findById(long id);

    @Select("SELECT id, name, age FROM tbl_user WHERE id = #{id}")
    RecordUser findRecordUserById(long id);

    @Select("SELECT id, name, age FROM tbl_user WHERE id = #{id}")
    LombokUser findLombokUserById(long id);

    @Select("SELECT id, name, age FROM tbl_user WHERE id = #{id}")
    LombokBuilderUser findLombokBuilderUserById(long id);

    @Select("SELECT id, name, age FROM tbl_user")
    List<User> findAllUser();

    @SelectProvider(type = UserInfoSql.class, method = "findUserBySearchParam")
    List<User> findUserBySearchParam(User user);

    class UserInfoSql {
        public String findUserBySearchParam(User user) {
            // 這段也可以用在 @Select()
            return """
                    <script>
                        select id, name, age from tbl_user
                        <where>
                            <if test="name != null">
                             AND name = #{name}
                             </if>
                             <if test="age != null">
                             AND age = #{age}
                             </if>
                        </where>
                    </script>
                    """;
        }
    }
}
