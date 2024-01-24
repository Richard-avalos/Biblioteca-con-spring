package com.gestion.bibloteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.bibloteca.model.Libros;

public interface LibrosDao extends JpaRepository<Libros, Integer> {

}
