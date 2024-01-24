package com.gestion.bibloteca.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class PlazoService {

    public String generarFechaPlazo() { 
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaPlazo = fechaActual.plusDays(5);
        return fechaPlazo.format(DateTimeFormatter.ofPattern("d-MM-yyyy"));
    }
}