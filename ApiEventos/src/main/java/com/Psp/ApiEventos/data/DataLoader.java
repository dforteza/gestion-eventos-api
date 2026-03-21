package com.Psp.ApiEventos.data;

import com.Psp.ApiEventos.domain.Category;
import com.Psp.ApiEventos.domain.Event;
import com.Psp.ApiEventos.repository.ICategoryRepo;
import com.Psp.ApiEventos.repository.IEventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner 
{

    private final ICategoryRepo categoryRepo;
    private final IEventRepo eventRepo;

    @Override
    public void run(String... args) throws Exception 
    {
        
        // Crear categorías
        Category conciertos = new Category();
        conciertos.setName("Conciertos");
        conciertos.setDescription("Eventos musicales y conciertos");
        categoryRepo.save(conciertos);
        
        Category deportes = new Category();
        deportes.setName("Deportes");
        deportes.setDescription("Eventos deportivos");
        categoryRepo.save(deportes);
        
        Category conferencias = new Category();
        conferencias.setName("Conferencias");
        conferencias.setDescription("Charlas y conferencias");
        categoryRepo.save(conferencias);
        
        // Crear eventos
        Event evento1 = new Event();
        evento1.setName("Concierto de Rock");
        evento1.setDate(LocalDate.of(2026, 6, 15));
        evento1.setLocation("Estadio Nacional");
        evento1.setCategory(conciertos);
        eventRepo.save(evento1);
        
        Event evento2 = new Event();
        evento2.setName("Final de Fútbol");
        evento2.setDate(LocalDate.of(2026, 5, 20));
        evento2.setLocation("Estadio Olímpico");
        evento2.setCategory(deportes);
        eventRepo.save(evento2);
        
        Event evento3 = new Event();
        evento3.setName("Tech Conference 2026");
        evento3.setDate(LocalDate.of(2026, 9, 10));
        evento3.setLocation("Centro de Convenciones");
        evento3.setCategory(conferencias);
        eventRepo.save(evento3);
        
        System.out.println("✅ Datos de prueba cargados");
        System.out.println("📊 Categorías: " + categoryRepo.count());
        System.out.println("🎫 Eventos: " + eventRepo.count());
    }
}