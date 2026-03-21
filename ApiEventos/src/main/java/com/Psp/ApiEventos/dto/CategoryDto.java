package com.Psp.ApiEventos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDto 
{
    private Long    id;
    @NotBlank(message = "El nombre de categoria es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe estar entre 3 y 50 caracteres")
    private String  name;
    @Size(max = 50, message = "La descripcion no puede exceder los 50 caracteres")
    private String  description;    
}
