
package com.sda.party.controller;

import com.sda.party.dto.UserDto;
import com.sda.party.model.User;
//import com.sda.party.repository.PortalUserRepository;
//import com.sda.party.service.PortalUserService;
import com.sda.party.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public String register(@ModelAttribute("user") @Validated UserDto user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user1 = new User();
        user1.setLogin(user.getLogin());
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user1);

        return "redirect:/login";
    }
}

