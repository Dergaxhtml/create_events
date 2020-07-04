package com.sda.party.service;

import com.sda.party.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        com.sda.party.model.User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
    }
}