package com.gestion.bibloteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Libros")
public class Libros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Libro;
	
	@Column
	@NotNull(message = "Debe ingresar las existencias")
	private Integer ISBN;

	@ManyToOne
	@JoinColumn(name = "Id_Autor")
	@NotNull(message = "Debe seleccionar un autor")

	private Autores autor;

	@ManyToOne
	@JoinColumn(name = "Id_Genero")
	@NotNull(message = "Debe seleccionar un género")

	private Generos genero;

	@Column
	@NotBlank(message = "Debe ingresar un titulo")
	private String Titulo;
	
	@Column
	@NotNull(message = "Debe ingresar las existencias")
	private Integer Existencias;
	
	@Column
	private Boolean Disponibilidad;
	
	

	public Integer getId_Libro() {
		return Id_Libro;
	}




	public void setId_Libro(Integer id_Libro) {
		Id_Libro = id_Libro;
	}




	public Integer getISBN() {
		return ISBN;
	}




	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}




	public Autores getAutor() {
		return autor;
	}




	public void setAutor(Autores autor) {
		this.autor = autor;
	}




	public Generos getGenero() {
		return genero;
	}




	public void setGenero(Generos genero) {
		this.genero = genero;
	}




	public String getTitulo() {
		return Titulo;
	}




	public void setTitulo(String titulo) {
		Titulo = titulo;
	}




	public Integer getExistencias() {
		return Existencias;
	}




	public void setExistencias(Integer existencias) {
		Existencias = existencias;
	}




	public Boolean getDisponibilidad() {
		return Disponibilidad;
	}




	public void setDisponibilidad(Boolean disponibilidad) {
		Disponibilidad = disponibilidad;
	}



	

	public Libros(Integer id_Libro, Integer iSBN, Autores autor, Generos genero, String titulo, Integer existencias,
			Boolean disponibilidad) {
		super();
		Id_Libro = id_Libro;
		ISBN = iSBN;
		this.autor = autor;
		this.genero = genero;
		Titulo = titulo;
		Existencias = existencias;
		Disponibilidad = disponibilidad;
	}




	public Libros() {
		super();
	}
	
	
	
}