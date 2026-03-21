package com.Psp.ApiEventos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Psp.ApiEventos.domain.Category;
import com.Psp.ApiEventos.dto.CategoryDto;
import com.Psp.ApiEventos.mapper.CategoryMapper;
import com.Psp.ApiEventos.service.ICategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController 
{
    
    private final ICategoryService  categoryService;
    private final CategoryMapper    categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() 
    {
        List<Category> categories = categoryService.findAll();
    
        List<CategoryDto> responseDtos = categoryMapper.toDtoList(categories);
    
        return (new ResponseEntity<>(responseDtos, HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) 
    {
        Category category = categoryService.findById(id);
    
        CategoryDto responseDto = categoryMapper.toDto(category);
    
        return (new ResponseEntity<>(responseDto, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) 
    {
        Category categoryToSave = categoryMapper.toEntity(categoryDto);
        Category savedCategory = categoryService.save(categoryToSave);
        CategoryDto responseDto = categoryMapper.toDto(savedCategory);
        
        return (new ResponseEntity<>(responseDto, HttpStatus.CREATED));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(
        @PathVariable Long id,
        @Valid @RequestBody CategoryDto categoryDto
    ) 
    {
        // 1- Buscar categoría existente
        Category categoryToUpdate = categoryService.findById(id);
        
        // 2- Actualizar campos desde DTO
        categoryMapper.updateFromDto(categoryDto, categoryToUpdate);
        
        // 3- Guardar cambios
        Category updatedCategory = categoryService.save(categoryToUpdate);
        
        // 4- Convertir a DTO de respuesta
        CategoryDto responseDto = categoryMapper.toDto(updatedCategory);
        
        return (new ResponseEntity<>(responseDto, HttpStatus.OK));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) 
    {
        categoryService.deleteById(id);
        return (new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}