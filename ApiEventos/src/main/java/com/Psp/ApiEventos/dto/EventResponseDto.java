package com.Psp.ApiEventos.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EventResponseDto 
{
    private Long        id;
    private String      name;
    private LocalDate   date;
    private String      location;

    private Long        categoryId;
    private String      categoryName;
}
