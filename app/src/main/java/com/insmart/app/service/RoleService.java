package com.insmart.app.service;

import com.insmart.app.model.Role;
import com.insmart.app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    public Role update(Role role,Long id) {
        Role role1 = roleRepository.findById(id).get();
        role1.setName(role.getName());
        role1.setCode(role.getCode());
        return roleRepository.save(role);
    }

}
