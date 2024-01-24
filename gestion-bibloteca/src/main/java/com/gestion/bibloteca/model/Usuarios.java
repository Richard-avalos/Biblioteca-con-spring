package com.gestion.bibloteca.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


@Entity
@Table(name = "Usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Usuario;
	
	@Column
	@NotNull(message = "Debe ingresar el carnet del usuario")
	private String CarnetUsuario;
	
	@Column
	@NotBlank(message = "Debe ingresar el nombre del usuario")
	private String Nombre;
	
	@Column
	@NotBlank(message = "Debe ingresar la direccion del usuario")
	private String Direccion;
	
	@Column
	@NotBlank(message = "Debe ingresar el telefono del usuario")
	private String Telefono;
	
	@Column
	@NotBlank(message = "Debe ingresar sel correo del usuario")
	private String CorreoElectronico;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe ingresar su fecha de nacimiento")
	private LocalDate FechaNacimiento;
	
	@Column
	private LocalDateTime FechaRegistro;
	
	@Column
	private Boolean Estado;

	

	public Integer getId_Usuario() {
		return Id_Usuario;
	}



	public void setId_Usuario(Integer id_Usuario) {
		Id_Usuario = id_Usuario;
	}



	public String getCarnetUsuario() {
		return CarnetUsuario;
	}



	public void setCarnetUsuario(String carnetUsuario) {
		CarnetUsuario = carnetUsuario;
	}



	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getDireccion() {
		return Direccion;
	}



	public void setDireccion(String direccion) {
		Direccion = direccion;
	}



	public String getTelefono() {
		return Telefono;
	}



	public void setTelefono(String telefono) {
		Telefono = telefono;
	}



	public String getCorreoElectronico() {
		return CorreoElectronico;
	}



	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}



	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}



	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}



	public LocalDateTime getFechaRegistro() {
		return FechaRegistro;
	}



	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}



	public Boolean getEstado() {
		return Estado;
	}



	public void setEstado(Boolean estado) {
		Estado = estado;
	}


	@PrePersist
	public void asignarfechaRegistro() {
		FechaRegistro = LocalDateTime.now();
	}
	

	public Usuarios(Integer id_Usuario, String carnetUsuario, String nombre, String direccion, String telefono,
			String correoElectronico,
			@Past @NotNull(message = "Debe ingresar su fecha de nacimiento") LocalDate fechaNacimiento,
			LocalDateTime fechaRegistro, Boolean estado) {
		super();
		Id_Usuario = id_Usuario;
		CarnetUsuario = carnetUsuario;
		Nombre = nombre;
		Direccion = direccion;
		Telefono = telefono;
		CorreoElectronico = correoElectronico;
		FechaNacimiento = fechaNacimiento;
		FechaRegistro = fechaRegistro;
		Estado = estado;
	}



	public Usuarios() {
		super();
	}

	
	

	
	
	
	
	
}
