package com.gestion.bibloteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.bibloteca.model.Autores;



public interface AutoresDao extends JpaRepository<Autores, Integer> {
	
	

}
