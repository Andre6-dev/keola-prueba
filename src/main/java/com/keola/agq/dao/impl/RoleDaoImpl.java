package com.keola.agq.dao.impl;

import com.keola.agq.dao.RoleDao;
import com.keola.agq.entity.Role;
import com.keola.agq.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * andre on 29/11/2023
 */
@Repository("role-jpa")
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> selectRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
