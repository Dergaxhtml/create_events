package com.sda.party.controller;

import com.sda.party.email.SendEmail;
import com.sda.party.model.Event;
import com.sda.party.model.User;
import com.sda.party.repository.EventRepository;
import com.sda.party.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/event")
    public String event(Model model) {
        model.addAttribute("event", new Event());
        return "event";
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String event(@ModelAttribute("event") @Validated Event event, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "event";
        }

        Event newEvent = new Event();
        newEvent.setName(event.getName());
        newEvent.setCity(event.getCity());


        eventRepository.save(newEvent);

        List<User> list = userRepository.findAll();
        SendEmail sender = new SendEmail();
  sender.sendEmail(list);


        return "redirect:/event";
    }
}
