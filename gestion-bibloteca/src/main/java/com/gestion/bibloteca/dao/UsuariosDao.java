package com.gestion.bibloteca.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.bibloteca.model.Usuarios;

public interface UsuariosDao extends JpaRepository<Usuarios, Integer> {

}
