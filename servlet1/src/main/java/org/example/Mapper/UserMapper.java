package org.example.Mapper;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

public interface UserMapper {
    @Select("select * from user where name=#{name} and password=#{password}")
    User login(User user);
}
