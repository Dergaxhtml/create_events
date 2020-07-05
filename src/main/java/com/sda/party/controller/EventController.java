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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/event")
    public String event(Model model) {
        model.addAttribute("event", new EventDTO());
        return "event";
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String event(@ModelAttribute("event") @Validated EventDTO event, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "event";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(event.getEventDate(), formatter);

        Event newEvent = new Event();
        newEvent.setName(event.getName());
        newEvent.setCity(event.getCity());
        newEvent.setAddress(event.getAddress());
        newEvent.setEventDate(date);

        eventRepository.save(newEvent);

        List<User> list = userRepository.findAll();
        SendEmail sender = new SendEmail();
        sender.sendEmail(list);


        return "redirect:/event";
    }
}
