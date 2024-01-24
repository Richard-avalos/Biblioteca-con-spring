package com.gestion.bibloteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.bibloteca.model.Generos;

public interface GenerosDao extends JpaRepository<Generos, Integer>{
}

