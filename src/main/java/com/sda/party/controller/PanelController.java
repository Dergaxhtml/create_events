package com.sda.party.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanelController {

    @RequestMapping("/panel")
    public String panel(){
        return "panel";
    }
}
