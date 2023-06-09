package com.example.demo.daoimpl.springdatajpa;

import com.example.demo.dao.hibernate.RoleDao;
import com.example.demo.daoimpl.repository.RoleRepository;
import com.example.demo.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleSpringDataJPADao")
public class RoleDaoSpringDataJPAImpl implements RoleDao {
    private Logger logger = LoggerFactory.getLogger(RoleDaoSpringDataJPAImpl.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        Role savedRole = roleRepository.save(role);
        return savedRole;
    }

    @Override
    public boolean delete(Role role) {
        boolean deleteResult = false;
        try {
            roleRepository.delete(role);
            deleteResult = true;
        } catch (IllegalArgumentException iae) {
            logger.error("Delete Role failed, input Role={}, error={}", role, iae.getMessage());
        }
        return deleteResult;
    }

    @Override
    public List<Role> findAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }
}
