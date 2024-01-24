package com.gestion.bibloteca.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


@Entity
@Table(name = "Empleados")
public class Empleados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Empleado;
	
	@Column
	@NotBlank(message = "Debe ingresar un nombre")
	private String Nombre;
	
	@Column
	@NotBlank(message = "Debe ingresar una direccion")
	private String Direccion;
	
	@Column
	@NotBlank(message = "Debe ingresar un telefono")
	private String Telefono;
	
	
	@NotEmpty(message = "Debe ingresar un email")
	@Email
	private String CorreoElectronico;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe ingresar su fecha de nacimiento")
	private LocalDate FechaNacimiento;
	
	@Column
	private LocalDateTime FechaContratacion;
	
	@Column
	private Boolean Estado;

	
	public Integer getId_Empleado() {
		return Id_Empleado;
	}


	public void setId_Empleado(Integer id_empleado) {
		Id_Empleado = id_empleado;
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

	public LocalDateTime getFechaContratacion() {
		return FechaContratacion;
	}

	public void setFechaContratacion(LocalDateTime fechaContratacion) {
		FechaContratacion = fechaContratacion;
	}
	
	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}

	public Empleados() {
		super();
	}
	
	
	@PrePersist
	public void asignarfechaRegistro() {
		FechaContratacion = LocalDateTime.now();
	}
	
	
	
	public Empleados(Integer id_empleado, String nombre, String direccion, String telefono, String correoElectronico,
			@Past @NotNull(message = "Debe ingresar su fecha de nacimiento") LocalDate fechaNacimiento,
			LocalDateTime fechaContratacion, Boolean estado) {
		super();
		Id_Empleado = id_empleado;
		Nombre = nombre;
		Direccion = direccion;
		Telefono = telefono;
		CorreoElectronico = correoElectronico;
		FechaNacimiento = fechaNacimiento;
		FechaContratacion = fechaContratacion;
		Estado = estado;
	}
	
	
	
	

	
	
}
