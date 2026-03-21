package com.Psp.ApiEventos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.Psp.ApiEventos.domain.Category;
import com.Psp.ApiEventos.dto.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper 
{
    // 1- DTO Entrada -> Entidad (creación o actualización)
    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "events", ignore = true)
    Category toEntity(CategoryDto categoryDto);
    
    // 2- Entidad -> DTO Salida (para getById o después de crear/actualizar)
    CategoryDto toDto(Category category); 
    List<CategoryDto> toDtoList(List<Category> categories); 
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "events", ignore = true)
    void updateFromDto(CategoryDto dto, @MappingTarget Category entity);
    
}
