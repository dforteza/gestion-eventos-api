package com.Psp.ApiEventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Psp.ApiEventos.domain.Event;

public interface IEventRepo extends JpaRepository<Event, Long>
{}
