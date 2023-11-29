package com.keola.agq.dao;

import com.keola.agq.entity.Role;

import java.util.Optional;

public interface RoleDao {

    Optional<Role> selectRoleByName(String name);
}
