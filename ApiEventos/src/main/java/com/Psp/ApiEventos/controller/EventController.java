package com.Psp.ApiEventos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Psp.ApiEventos.domain.Event;
import com.Psp.ApiEventos.dto.EventRequestDto;
import com.Psp.ApiEventos.dto.EventResponseDto;
import com.Psp.ApiEventos.mapper.EventMapper;
import com.Psp.ApiEventos.service.IEventService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequiredArgsConstructor
@RequestMapping("api/events")
public class EventController
{
    private final IEventService eventService;
    private final EventMapper   eventMapper;

    @GetMapping()
    public ResponseEntity<List<EventResponseDto>> getAllEvents() 
    {
        // 1- Service
        List<Event> events= eventService.findAll();

        // 2- Transformar
        List<EventResponseDto> eventResponseDtos = eventMapper.toDtoList(events);

        return (new ResponseEntity<>(eventResponseDtos, HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id) 
    {
        // 1- Service
        Event event = eventService.findById(id);
        // 2- Transformar
        EventResponseDto eventResponseDto = eventMapper.toDto(event);

        return (new ResponseEntity<>(eventResponseDto, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventRequestDto requestDto) 
    {
        // 1- Transformar y // 2 Guardar
        Event eventToSave = eventService.save(eventMapper.toEntity(requestDto));

        // 3- Transformar
        EventResponseDto eventResponseDto = eventMapper.toDto(eventToSave);

        return (new ResponseEntity<>(eventResponseDto, HttpStatus.CREATED));
    }


@PutMapping("{id}")
public ResponseEntity<EventResponseDto> updateEvent(
    @PathVariable Long id,
    @Valid @RequestBody EventRequestDto requestDto
) 
{
    // 1- Buscar por el ID del path
    Event eventToUpdate = eventService.findById(id);
    
    // 2- Actualizar campos desde DTO
    eventMapper.updateFromDto(requestDto, eventToUpdate);
    
    // 3- Guardar cambios
    Event updatedEvent = eventService.save(eventToUpdate);
    
    // 4- Convertir a DTO
    EventResponseDto responseDto = eventMapper.toDto(updatedEvent);
    
    return ResponseEntity.ok(responseDto);
}

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id)
    {
        eventService.deleteById(id);

        return (new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
