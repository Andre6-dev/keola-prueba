package com.keola.agq.dao;

import com.keola.agq.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * andre on 29/11/2023
 */
public interface UserDao {

    Optional<User> selectUserById(UUID id);

    Optional<User> selectUserByUsername(String username);

    List<User> findAllUsers();

    User insertUser(User user);

}
