package com.Psp.ApiEventos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.Psp.ApiEventos.domain.Event;
import com.Psp.ApiEventos.dto.EventRequestDto;
import com.Psp.ApiEventos.dto.EventResponseDto;

@Mapper(componentModel = "spring")
public interface EventMapper
{
    // C + U
    Event                   toEntity(EventRequestDto eventRequestDto);

    // R
    EventResponseDto        toDto(Event event);
    List<EventResponseDto>  toDtoList(List<Event> events);

    void                    updateFromDto(EventRequestDto eventRequestDto, @MappingTarget Event event);

    
}
