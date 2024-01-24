package com.gestion.bibloteca.model;



import java.time.LocalDateTime;


import jakarta.persistence.*;






@Entity
@Table(name = "Prestamos")
public class Prestamos {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer Id_Prestamo;

	    
	    @ManyToOne
	    @JoinColumn(name = "Id_Libro")
	   
	    private Libros libro;

	   
	    @ManyToOne
	    @JoinColumn(name = "Id_Usuario")
	    
	    private Usuarios usuario;

	    @ManyToOne
	    @JoinColumn(name = "Id_Empleado")
	   
	    private Empleados empleado;

	    @Column
	    private LocalDateTime plazo;

	    @Column
	    private LocalDateTime fechaInicio;

		public Integer getId_Prestamo() {
			return Id_Prestamo;
		}

		public void setId_Prestamo(Integer id_Prestamo) {
			Id_Prestamo = id_Prestamo;
		}

		public Libros getLibro() {
			return libro;
		}

		public void setLibro(Libros libro) {
			this.libro = libro;
		}

		public Usuarios getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuarios usuario) {
			this.usuario = usuario;
		}

		public Empleados getEmpleado() {
			return empleado;
		}

		public void setEmpleado(Empleados empleado) {
			this.empleado = empleado;
		}

		public LocalDateTime getPlazo() {
			return plazo;
		}

		public void setPlazo(LocalDateTime plazo) {
			this.plazo = plazo;
		}

		public LocalDateTime getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(LocalDateTime fechaInicio) {
			this.fechaInicio = fechaInicio;
		}
		
		@PrePersist
		public void asignarfechaRegistro() {
			fechaInicio = LocalDateTime.now();
		}

		public Prestamos(Integer id_Prestamo, Libros libro, Usuarios usuario, Empleados empleado, LocalDateTime plazo,
				LocalDateTime fechaInicio) {
			super();
			Id_Prestamo = id_Prestamo;
			this.libro = libro;
			this.usuario = usuario;
			this.empleado = empleado;
			this.plazo = plazo;
			this.fechaInicio = fechaInicio;
		}

		public Prestamos() {
			super();
		}

	 
	    
	
	





	
	
	
}
