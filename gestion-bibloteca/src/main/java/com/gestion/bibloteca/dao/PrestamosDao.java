package com.gestion.bibloteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.bibloteca.model.Prestamos;

public interface PrestamosDao extends JpaRepository<Prestamos, Integer> {

}
