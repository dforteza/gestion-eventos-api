package com.Psp.ApiEventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Psp.ApiEventos.domain.Event;
import com.Psp.ApiEventos.exception.ResourceNotFoundException;
import com.Psp.ApiEventos.repository.IEventRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements IEventService
{
    private final IEventRepo eventRepo;

    @Override
    public Event save(Event event) 
    {
        return eventRepo.save(event);
    }


    @Override
    public Event findById(Long id) 
    {
        return (eventRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento no encontrado con ID: " + id))
            );
    }

    @Override
    public List<Event> findAll() 
    {
        return (eventRepo.findAll());
    }

    @Override
    public void deleteById(Long id) 
    {
        Event eventToDelete = findById(id);
        eventRepo.delete(eventToDelete);
    }
    
}
