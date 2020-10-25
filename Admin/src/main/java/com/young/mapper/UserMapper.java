package com.young.mapper;

import com.young.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    User getUser(String name,String password);

    String getPassword(String name);
}
