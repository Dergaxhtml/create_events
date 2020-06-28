
package com.sda.party.controller;

import com.sda.party.model.User;
//import com.sda.party.repository.PortalUserRepository;
//import com.sda.party.service.PortalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PortalUserController {

    @GetMapping("/home")
    public String homePage(){

        return "homepage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}

