package com.example.Party.controller;

import com.example.Party.repository.PortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalUserController {
    @Autowired
    private PortalUserRepository portalUserRepository;

    @GetMapping("/home")
    public String homePage(){

        return "homepage";
    }
}
