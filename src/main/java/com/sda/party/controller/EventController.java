package com.sda.party.controller;

import com.sda.party.dto.EventDto;
import com.sda.party.model.Event;
import com.sda.party.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/event")
    public String event(Model model) {
        model.addAttribute("event", new EventDto());
        return "event";
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String event(@ModelAttribute("event") @Validated EventDto event, BindingResult bindingResult) {

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

        return "redirect:/event";
    }
}
