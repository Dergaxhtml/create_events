package com.sda.party.controller;

import com.sda.party.dto.EventDto;
import com.sda.party.email.SendEmail;
import com.sda.party.mapper.EventMapper;
import com.sda.party.model.Event;
import com.sda.party.model.User;
import com.sda.party.repository.EventRepository;
import com.sda.party.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("event")
    public String event(Model model) {

        model.addAttribute("event", new EventDto());
        return "event";
    }

    @RequestMapping(value = "event", method = RequestMethod.POST)
    public String event(@ModelAttribute("event") @Validated EventDto event, BindingResult bindingResult) throws MessagingException {


        if (bindingResult.hasErrors()) {
            return "event";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Event newEvent = new Event();
        newEvent.setName(event.getName());
        newEvent.setCity(event.getCity());

        newEvent.setAddress(event.getAddress());
        try {
            LocalDate date = LocalDate.parse(event.getEventDate(), formatter);
            newEvent.setEventDate(date);
        } catch (DateTimeException e) {
            return "event";
        }

        eventRepository.save(newEvent);

        List<User> list = userRepository.findAll();
        SendEmail sender = new SendEmail();
        sender.sendEmail(list);

        return "redirect:/event";
    }

    @RequestMapping("/events")
    public String eventsShowAll(Model model) {

        List<Event> events = eventRepository.findAll();

        List<EventDto> dtos = EventMapper.mapEntityToDto(events);

        model.addAttribute("events",dtos);

        return "events";
    }

    @ResponseBody
    @RequestMapping(value = "events/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> showRowFromDBById(@PathVariable("id") int id){


        Event event = eventRepository.getById(id);

        EventDto dto = EventMapper.mapEntityToDto(id);



return ResponseEntity.ok(dto);
    }
}
