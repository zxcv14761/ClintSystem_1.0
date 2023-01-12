package com.ya666.Mapper;

import com.ya666.Pojo.User;


public interface UserMapper {

    User queryUserByUsername(String username);

    int addUser(User user);




}
