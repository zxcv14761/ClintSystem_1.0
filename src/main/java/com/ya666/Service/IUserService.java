package com.ya666.Service;

import com.ya666.Pojo.User;

public interface IUserService {

    User userLogin(User user);

    void addUser(User user);
}
