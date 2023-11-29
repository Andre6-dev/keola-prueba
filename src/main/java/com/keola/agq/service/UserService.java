package com.keola.agq.service;

import com.keola.agq.dao.RoleDao;
import com.keola.agq.dao.UserDao;
import com.keola.agq.dto.UserDto;
import com.keola.agq.entity.Role;
import com.keola.agq.entity.User;
import com.keola.agq.entity.enums.RoleEnum;
import com.keola.agq.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * andre on 29/11/2023
 */
@Slf4j(topic = "UserService")
@Service
public class UserService {

    private final UserDao userDao;

    private final RoleDao roleDao;

    private final UserMapper userMapper;

    public UserService(@Qualifier("user-jpa") UserDao userDao, @Qualifier("role-jpa") RoleDao roleDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.userMapper = userMapper;
    }

    public UserDto findUserByUsername(String username) {
        return this.userDao.selectUserByUsername(username)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User with username [%s] not found".formatted(username)));
    }

    public List<UserDto> findAllUsers() {
        return this.userDao.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);

        Role role = roleDao.selectRoleByName(RoleEnum.ROLE_ADMIN.name())
                .orElseThrow(() -> new RuntimeException("Role with name [ADMIN_ROLE] not found"));

        user.assignRoleToUser(role);

        return userMapper.toDto(userDao.insertUser(user));
    }
}
