package com.Psp.ApiEventos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.Psp.ApiEventos.domain.Category;
import com.Psp.ApiEventos.domain.Event;
import com.Psp.ApiEventos.dto.EventRequestDto;
import com.Psp.ApiEventos.dto.EventResponseDto;
import com.Psp.ApiEventos.exception.ResourceNotFoundException;
import com.Psp.ApiEventos.repository.ICategoryRepo;

@Mapper(componentModel = "spring")
public abstract class EventMapper  // ✅ Cambiar a abstract class
{
    @Autowired
    protected ICategoryRepo categoryRepo;  // ✅ Inyectar repositorio

    // Convertir DTO a Entity (para crear)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategoryIdToCategory")  // ✅ Usar el método custom
    public abstract Event toEntity(EventRequestDto eventRequestDto);

    // Convertir Entity a DTO (para respuestas)
    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    public abstract EventResponseDto toDto(Event event);
    
    // Convertir lista de Entities a lista de DTOs
    public abstract List<EventResponseDto> toDtoList(List<Event> events);

    // Actualizar Entity desde DTO (para editar)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", source = "categoryId", qualifiedByName = "mapCategoryIdToCategory")  // ✅ Usar el método custom
    public abstract void updateFromDto(EventRequestDto eventRequestDto, @MappingTarget Event event);

    // ✅ Método custom con @Named para que MapStruct lo encuentre
    @Named("mapCategoryIdToCategory")
    protected Category mapCategoryIdToCategory(Long categoryId) 
    {
        if (categoryId == null) 
        {
            return null;
        }
        
        // Buscar la categoría en BD y lanzar excepción si no existe
        return categoryRepo.findById(categoryId)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Error: Categoría no encontrada con ID: " + categoryId
            ));
    }
}