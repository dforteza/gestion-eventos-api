package com.Psp.ApiEventos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Psp.ApiEventos.domain.Category;
import com.Psp.ApiEventos.repository.ICategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService
{
    private final ICategoryRepo categoryRepo;
    
    @Override
    public void deleteById(Long id) 
    {   
        Category categoryToDelete = this.findById(id);    
        categoryRepo.delete(categoryToDelete); 
    }

    @Override
    public List<Category> findAll() 
    {
        return (categoryRepo.findAll());
    }

    @Override
    public Category findById(Long id) 
    {
        return (
            categoryRepo
                .findById(id)
                .orElseThrow()
        );
    }

    @Override
    public Category save(Category category) 
    {
        return (categoryRepo.save(category));
    }
}
