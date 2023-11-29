package com.keola.agq.dao.impl;

import com.keola.agq.dao.UserDao;
import com.keola.agq.entity.User;
import com.keola.agq.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * andre on 29/11/2023
 */
@Repository("user-jpa")
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {


    private final UserRepository userRepository;

    @Override
    public Optional<User> selectUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User insertUser(User user) {
        return null;
    }
}
