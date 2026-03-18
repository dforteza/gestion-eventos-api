package com.Psp.ApiEventos.service;

import java.util.List;

import com.Psp.ApiEventos.domain.Category;


public interface ICategoryService 
{
    // C + U
    Category        save(Category category);
    // R
    Category        findById(Long id);
    List<Category>  findAll();
    // D
    void            deleteById(Long id);
}
