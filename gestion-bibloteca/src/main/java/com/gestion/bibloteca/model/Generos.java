package com.gestion.bibloteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Generos")
public class Generos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Genero;
	
	@Column
	private String Nombre;
	
	@Column
	private String Descripcion;

	
	
	



	public Integer getId_Genero() {
		return Id_Genero;
	}







	public void setId_Genero(Integer id_Genero) {
		Id_Genero = id_Genero;
	}







	public String getNombre() {
		return Nombre;
	}







	public void setNombre(String nombre) {
		Nombre = nombre;
	}







	public String getDescripcion() {
		return Descripcion;
	}







	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}



	



	public Generos(Integer id_Genero, String nombre, String descripcion) {
		super();
		Id_Genero = id_Genero;
		Nombre = nombre;
		Descripcion = descripcion;
	}







	public Generos() {
		super();
	}

	
	
	
	
}
