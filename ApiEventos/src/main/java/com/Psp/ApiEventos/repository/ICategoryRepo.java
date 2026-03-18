package com.Psp.ApiEventos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Psp.ApiEventos.domain.Category;

public interface ICategoryRepo extends JpaRepository<Category, Long>
{}
