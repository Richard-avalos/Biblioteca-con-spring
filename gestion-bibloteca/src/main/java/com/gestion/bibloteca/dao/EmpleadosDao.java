package com.gestion.bibloteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.bibloteca.model.Empleados;

public interface EmpleadosDao extends JpaRepository<Empleados, Integer>{

}
