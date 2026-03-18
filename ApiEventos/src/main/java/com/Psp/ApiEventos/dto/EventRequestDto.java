package com.Psp.ApiEventos.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class EventRequestDto 
{
    private String      name;
    private LocalDate   date;
    private String      location;
    private Long        categoryId;
}
