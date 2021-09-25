package com.test.devops.restapidemo.service;

import java.util.List;
import java.util.Map;

import com.test.devops.restapidemo.model.User;

public interface IUserService {
    //declaro los metodos y los implemento en userservice
    List<User> getAllUsers();

    User getUserById(Long userId);

    User saveUser(User user);

    User updateUser(Long userId, User user);

    Map<String, Boolean>deleteUser(Long userId);
    
}
