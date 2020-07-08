package com.sda.party.mapper;

import com.sda.party.dto.EventDto;
import com.sda.party.model.Event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventMapper {
    public static EventDto mapEntityToDto(Event entity) {

        EventDto dto = new EventDto(entity.getName());
        dto.setId(entity.getId());
        dto.setCity(entity.getCity());
        dto.setAddress(entity.getAddress());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

      dto.setEventDate(dateFormat.format(entity.getEventDate()));

        return dto;
    }

    public static List<EventDto> mapEntityToDto(List<Event> entities) {

        List<EventDto> dtos = new ArrayList<>();

        for (Event event : entities) {
            dtos.add(mapEntityToDto(event));
        }

        return dtos;
    }
}
