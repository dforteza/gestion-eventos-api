package com.Psp.ApiEventos.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category 
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private String  description;

    @OneToMany(
        mappedBy = "category",
        cascade = CascadeType.ALL 
        // Permite eliminar una categoria que tiene eventos asociados
        // Sin esta condicion se produciria ConstraintViolation 
    )
    private Set<Event> events = new HashSet<>();
    
}
