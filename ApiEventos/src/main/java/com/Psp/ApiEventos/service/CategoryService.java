package com.Psp.ApiEventos.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Psp.ApiEventos.domain.Category;
import com.Psp.ApiEventos.exception.ResourceNotFoundException;
import com.Psp.ApiEventos.repository.ICategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService
{
    private final ICategoryRepo categoryRepo;
    
    @Override
    @Transactional
    public void deleteById(Long id) 
    {   
        // 1. Buscar categoría (lanza 404 si no existe)
        Category categoryToDelete = this.findById(id);
        
        // 2. Validar que no tenga eventos asociados
        if (!categoryToDelete.getEvents().isEmpty()) 
        {
            throw new ResourceNotFoundException("No se puede eliminar la categoria con ID: "+id);
        }
        
        // 3. Eliminar
        categoryRepo.delete(categoryToDelete); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() 
    {
        return (categoryRepo.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) 
    {
        return (
            categoryRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id))
        );
    }

    @Override
    @Transactional
    public Category save(Category category) 
    {
        return (categoryRepo.save(category));
    }
}
