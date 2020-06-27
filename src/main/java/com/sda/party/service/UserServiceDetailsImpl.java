package com.sda.party.service;

import com.sda.party.model.Role;
import com.sda.party.repository.PortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class UserServiceDetailsImpl implements UserDetailsService {
    @Autowired
    PortalUserRepository portalUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.sda.party.model.User user = portalUserRepository.findByLogin(s);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user!=null){
            for (Role role:user.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }else {
            throw new UsernameNotFoundException(s + "is not found");
        }
        return new User(user.getLogin(),user.getPassword(),grantedAuthorities);
    }
}
