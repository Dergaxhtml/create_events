package com.sda.party.controller;

import com.sda.party.model.Event;
import com.sda.party.model.User;
import com.sda.party.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/event")
    public String register(Model model) {
        model.addAttribute("event", new Event());
        return "event";
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String register(@ModelAttribute("event") @Validated Event event, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "event";
        }

        Event newEvent = new Event();
        newEvent.setName(event.getName());
        newEvent.setCity(event.getName());


        eventRepository.save(newEvent);

        return "redirect:/event";
    }
}
