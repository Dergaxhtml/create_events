package com.sda.party.controller;
import com.sda.party.dto.EventDto;
import com.sda.party.mapper.EventMapper;
import com.sda.party.model.Event;
import com.sda.party.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomepageController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/home")
    public String eventsShowAll(Model model) {

        List<Event> events = eventRepository.findAll();

        List<EventDto> dtos = EventMapper.mapEntityToDto(events);

        model.addAttribute("events",dtos);

        return "events";
    }
}
