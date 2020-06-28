package com.sda.party.service;


import com.sda.party.model.Role;
import com.sda.party.model.User;
import com.sda.party.repository.PortalUserRepository;
import com.sda.party.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PortalUserServiceImpl implements PortalUserService {


    @Autowired
    private PortalUserRepository portalUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
        portalUserRepository.save(user);
    }

}



