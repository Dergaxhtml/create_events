package com.sda.party.mapper;

import com.sda.party.dto.EventDto;
import com.sda.party.model.Event;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class EventMapper {
    public static EventDto mapEntityToDto(Event entity) {

        EventDto dto = new EventDto(entity.getName());
        dto.setId(entity.getId());
        dto.setCity(entity.getCity());
        dto.setAddress(entity.getAddress());
        dto.setEventDate(entity.getEventDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        return dto;
    }

    public static List<EventDto> mapEntityToDto(List<Event> entities) {

        List<EventDto> dtos = new ArrayList<>();

        for (Event event : entities) {
            dtos.add(mapEntityToDto(event));
        }

        return dtos;
    }

    public static EventDto mapEntityToDto(int id) {

        EventDto dto = new EventDto();
        dto.setId(id);


        return dto;
    }
}
