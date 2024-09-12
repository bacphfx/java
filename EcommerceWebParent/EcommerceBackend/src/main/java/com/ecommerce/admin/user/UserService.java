package com.ecommerce.admin.user;

import com.ecommerce.common.entity.Role;
import com.ecommerce.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public List<Role> listRoles(){
        return roleRepository.findAll();
    }
}
