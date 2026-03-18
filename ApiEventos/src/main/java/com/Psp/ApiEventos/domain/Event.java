package com.Psp.ApiEventos.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "events")
public class Event
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long        id;
    private String      name;
    private LocalDate   date;
    private String      location;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
}