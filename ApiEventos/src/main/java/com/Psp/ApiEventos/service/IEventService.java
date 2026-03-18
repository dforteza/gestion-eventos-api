package com.Psp.ApiEventos.service;

import java.util.List;

import com.Psp.ApiEventos.domain.Event;

public interface IEventService
{
    // C + U
    Event       save(Event event);
    // R
    Event       findById(Long id);
    List<Event> findAll();
    // D
    void        deleteById(Long id);
}
