package com.gestion.bibloteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Autores")
public class Autores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Autor;
	
	@Column
	@NotBlank(message = "Debe ingresar un autor")

	private String Nombre;
	
	public Integer getId_Autor() {
		return Id_Autor;
	}
	public void setId_Autor(Integer id_Autor) {
		Id_Autor = id_Autor;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Autores(Integer id_Autor, String nombre) {
		super();
		Id_Autor = id_Autor;
		Nombre = nombre;
	}
	public Autores() {
		super();
	}



}
