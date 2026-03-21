package com.Psp.ApiEventos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EventRequestDto 
{
    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe estar entre 3 y 50 caracteres")
    private String      name;
    @NotNull(message = "La fecha del evento es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser hoy o en el futuro")
    private LocalDate   date;
    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(max = 50, message = "La localizacion no puede superar los 50 caracteres")
    private String      location;
    @NotNull(message = "El ID de categoría es obligatorio")
    @Positive(message = "El ID de categoría debe ser positivo")
    private Long        categoryId;
}
