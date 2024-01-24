package com.gestion.bibloteca.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import com.gestion.bibloteca.dao.*;
import com.gestion.bibloteca.model.*;
import com.gestion.bibloteca.services.PlazoService;










@Controller
public class BiblotecaController {
	@Autowired
	private AutoresDao autoresDao;
	@Autowired
	private GenerosDao generosDao;
	@Autowired
	private LibrosDao librosDao;
	@Autowired
	private EmpleadosDao empleadosDao;
	@Autowired
	private UsuariosDao usuariosDao;
	@Autowired
	private PrestamosDao prestamosDao;
	@Autowired
	private PlazoService plazoService;
	
	//endpointPrincipal
	
	@GetMapping(value = {" ", "/"})
	public String menu(Model modelo){
		return "menu";
	}

	//endpoints de autores
	@GetMapping(value = "/nuevoAutor")
	public String nuevoAutor(Model modelo) {
		modelo.addAttribute("autor", new Autores());
		return "nuevoAutor";
	}
	
	@PostMapping(value = "/guardarAutor")
	public String guardarAutor(@Validated Autores autor, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("autor", autor);
			return "nuevoAutor";
		}
		
		autoresDao.save(autor);
		redirect.addFlashAttribute("msgExito", "El autor se ha registrado con exito.");
		return "redirect:/tablaAutores";
	}
	
	
	
	@GetMapping("/editarAutor/{Id_Autor}")
	    public String mostrarFormularioDeEditarAutor(@PathVariable Integer Id_Autor, Model modelo) {
	        Autores autor = autoresDao.findById(Id_Autor).orElse(null);

	        if (autor == null) {
	            return "redirect:/tablaAutores";
	        }

	        modelo.addAttribute("autor", autor);
	        return "nuevoAutor"; 
	   }

	 
	@PostMapping("/editarAutor/{Id_Autor}")
	  	public String actualizarAutor(@PathVariable Integer Id_Autor,  @Validated Autores autor, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
	        Autores autorDB = autoresDao.findById(Id_Autor).orElse(null);
	        if (autorDB == null) {
	            return "redirect:/tablaAutores";
	        }
	        if (bindingResult.hasErrors()) {
	            modelo.addAttribute("autor", autor);
	            return "nuevoAutor";
	        }
	        autorDB.setNombre(autor.getNombre());
	        autoresDao.save(autorDB);
	        redirect.addFlashAttribute("msgExito", "El autor ha sido actualizado con éxito.");
	        return "redirect:/tablaAutores";
	    }

	@PostMapping("/eliminar/{Id_Autor}")
		public String EliminarAutor(@PathVariable Integer Id_Autor, RedirectAttributes redirect) {
		   	Autores autor = autoresDao.findById(Id_Autor).orElse(null);
		   	autoresDao.delete(autor);
		   	redirect.addFlashAttribute("msgExito", "El contacto ha sido eliminado con exito.");
		    return "redirect:/tablaAutores";
	    
	}
	
	@GetMapping(value = "/tablaAutores")
	public String tablaAutores(Model modelo){
		List<Autores> autores = autoresDao.findAll();
		modelo.addAttribute("autores", autores);
		return "tablaAutores";
	}
	
	
	//endpoints para generos
	
	@GetMapping(value = "/nuevoGenero")
	public String nuevoGenero(Model modelo) {
		modelo.addAttribute("genero", new Generos());
		return "nuevoGenero";
	}
	
	@PostMapping(value = "/guardarGenero")
	public String guardarGenero(@Validated Generos genero, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("genero", genero);
			return "nuevoGenero";
		}
		
		generosDao.save(genero);
		redirect.addFlashAttribute("msgExito", "El genero se ha registrado con exito.");
		return "redirect:/tablaGeneros";
	}
	
	
	
	@GetMapping("/editarGenero/{Id_Genero}")
	    public String editarGenero(@PathVariable Integer Id_Genero, Model modelo) {
	        Generos genero = generosDao.findById(Id_Genero).orElse(null);

	        if (genero == null) {
	            return "redirect:/tablaGeneros";
	        }

	        modelo.addAttribute("genero", genero);
	        return "nuevoGenero"; 
	   }

	 
	@PostMapping("/editarGenero/{Id_Genero}")
	  	public String actualizarGenero(@PathVariable Integer Id_Genero,  @Validated Generos genero, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
	        Generos generoDB = generosDao.findById(Id_Genero).orElse(null);
	        if (generoDB == null) {
	            return "redirect:/tablaGeneros";
	        }
	        if (bindingResult.hasErrors()) {
	            modelo.addAttribute("genero", genero);
	            return "nuevoGenero";
	        }
	        
	        generoDB.setNombre(genero.getNombre());
	        generoDB.setDescripcion(genero.getDescripcion());
			
	        
	        generosDao.save(generoDB);
	        redirect.addFlashAttribute("msgExito", "El genero ha sido actualizado con éxito.");
	        return "redirect:/tablaGeneros";
	    }

	@PostMapping("/eliminarGenero/{Id_Genero}")
		public String EliminarGenero(@PathVariable Integer Id_Genero, RedirectAttributes redirect) {
		   	Generos genero = generosDao.findById(Id_Genero).orElse(null);
		   	generosDao.delete(genero);
		   	redirect.addFlashAttribute("msgExito", "El genero ha sido eliminado con exito.");
		    return "redirect:/tablaGeneros";
	    
		}
		
	@GetMapping(value = "/tablaGeneros")
		public String tablaGeneros(Model modelo){
			List<Generos> generos = generosDao.findAll();
			modelo.addAttribute("generos", generos);
			return "tablaGeneros";
		}
	
	
	//endpoints de usuarios
	@GetMapping(value = "/nuevoUsuario")
	public String nuevoUsuario(Model modelo) {
		modelo.addAttribute("usuario", new Usuarios());
		return "nuevoUsuario";
	}
	
	@PostMapping(value = "/guardarUsuario")
	public String guardarUsuario(@Validated Usuarios usuario, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("usuario", usuario);
			return "nuevoAutor";
		}
		
		usuariosDao.save(usuario);
		redirect.addFlashAttribute("msgExito", "El usuario se ha registrado con exito.");
		return "redirect:/tablaUsuarios";
	}
	
	
	
	@GetMapping("/editarUsuario/{Id_Usuario}")
	    public String mostrarFormularioDeEditarUsuario(@PathVariable Integer Id_Usuario, Model modelo) {
	        Usuarios usuario = usuariosDao.findById(Id_Usuario).orElse(null);

	        if (usuario == null) {
	            return "redirect:/tablaUsuarios";
	        }

	        modelo.addAttribute("usuario", usuario);
	        return "nuevoUsuario"; 
	   }

	 
	@PostMapping("/editarUsuario/{Id_Usuario}")
	  	public String actualizarUsuario(@PathVariable Integer Id_Usuario,  @Validated Usuarios usuario, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
	        Usuarios usuarioDB = usuariosDao.findById(Id_Usuario).orElse(null);
	        if (usuarioDB == null) {
	            return "redirect:/tablaUsuarios";
	        }
	        if (bindingResult.hasErrors()) {
	            modelo.addAttribute("usuario", usuario);
	            return "nuevoUsuario";
	        }
	        usuarioDB.setNombre(usuario.getNombre());
	        usuarioDB.setDireccion(usuario.getDireccion());
	        usuarioDB.setTelefono(usuario.getTelefono());
	        usuarioDB.setCorreoElectronico(usuario.getCorreoElectronico());
	        usuarioDB.setFechaNacimiento(usuario.getFechaNacimiento());
	        usuarioDB.setCarnetUsuario(usuario.getCarnetUsuario());
	        usuarioDB.setEstado(usuario.getEstado());
	        
	        usuariosDao.save(usuarioDB);
	        redirect.addFlashAttribute("msgExito", "El usuario ha sido actualizado con éxito.");
	        return "redirect:/tablaUsuarios";
	    }

	
	@PostMapping("/eliminarUsuario/{Id_Usuario}")
	public String EliminarUsuario(@PathVariable Integer Id_Usuario, RedirectAttributes redirect) {
	   	Usuarios usuario = usuariosDao.findById(Id_Usuario).orElse(null);
	   	usuariosDao.delete(usuario);
	   	redirect.addFlashAttribute("msgExito", "El usuario ha sido eliminado con exito.");
	    return "redirect:/tablaUsuarios";
    
}
	
	@GetMapping(value = "/tablaUsuarios")
	public String tablaGenero(Model modelo){
		List<Usuarios> usuarios = usuariosDao.findAll();
		modelo.addAttribute("usuarios", usuarios);
		return "tablaUsuarios";
	}
	
	
	//endpoints de empleados
	@GetMapping(value = "/nuevoEmpleado")
	public String nuevoEmpleado(Model modelo) {
		modelo.addAttribute("empleado", new Empleados());
		return "nuevoEmpleado";
	}
	
	@PostMapping(value = "/guardarEmpleado")
	public String guardarEmpleado(@Validated Empleados empleado, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("empleado", empleado);
			return "nuevoEmpleado";
		}
		
		empleadosDao.save(empleado);
		redirect.addFlashAttribute("msgExito", "El empleado se ha registrado con exito.");
		return "redirect:/tablaEmpleados";
	}
	
	
	
	@GetMapping("/editarEmpleado/{Id_Empleado}")
	    public String editarEmpleado(@PathVariable Integer Id_Empleado, Model modelo) {
	        Empleados empleado = empleadosDao.findById(Id_Empleado).orElse(null);

	        if (empleado == null) {
	            return "redirect:/tablaEmpleados";
	        }

	        modelo.addAttribute("empleado", empleado);
	        return "nuevoEmpleado"; 
	   }

	 
	@PostMapping("/editarEmpleado/{Id_Empleado}")
	  	public String actualizarEmpleado(@PathVariable Integer Id_Empleado,  @Validated Empleados empleado, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
	        Empleados empleadoDB = empleadosDao.findById(Id_Empleado).orElse(null);
	        if (empleadoDB == null) {
	            return "redirect:/tablaEmpleados";
	        }
	        if (bindingResult.hasErrors()) {
	            modelo.addAttribute("empleado", empleado);
	            return "nuevoEmpleado";
	        }
	        
	        empleadoDB.setNombre(empleado.getNombre());
	        empleadoDB.setDireccion(empleado.getDireccion());
	        empleadoDB.setTelefono(empleado.getTelefono());
	        empleadoDB.setCorreoElectronico(empleado.getCorreoElectronico());
	        empleadoDB.setFechaNacimiento(empleado.getFechaNacimiento());
	        empleadoDB.setEstado(empleado.getEstado());
	        
	        empleadosDao.save(empleadoDB);
	        redirect.addFlashAttribute("msgExito", "El empleado ha sido actualizado con éxito.");
	        return "redirect:/tablaEmpleados";
	    }

	
	@PostMapping("/eliminarEmpleado/{Id_Empleado}")
		public String EliminarEmpleado(@PathVariable Integer Id_Empleado, RedirectAttributes redirect) {
		   	Empleados empleado = empleadosDao.findById(Id_Empleado).orElse(null);
		   	empleadosDao.delete(empleado);
		   	redirect.addFlashAttribute("msgExito", "El empleado ha sido eliminado con exito.");
		    return "redirect:/tablaEmpleados";
	    
	}
	
	@GetMapping(value = "/tablaEmpleados")
	public String tablaEmpleados(Model modelo){
		List<Empleados> empleados = empleadosDao.findAll();
		modelo.addAttribute("empleados", empleados);
		return "tablaEmpleados";
	}
	
	
	//endopoints para libros
	@GetMapping(value = "/nuevoLibro")
	public String nuevoLibro(Model modelo) {
		
		List<Autores> listaAutores = autoresDao.findAll();
		List<Generos> listaGeneros = generosDao.findAll();
		
		modelo.addAttribute("libro", new Libros());
		modelo.addAttribute("listaAutores", listaAutores);
		modelo.addAttribute("listaGeneros", listaGeneros);
		
		return "nuevoLibro";
	}
	
	@PostMapping(value = "/guardarLibro")
	public String guardarLibro(@Valid Libros libro, BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("libro", libro);
			return "nuevoLibro";
		}
		
		librosDao.save(libro);
		redirect.addFlashAttribute("msgExito", "El libro se ha registrado con exito.");
		return "redirect:/tablaLibros";
	}
	
	
	
	@GetMapping("/editarLibro/{Id_Libro}")
	    public String editarLibro(@PathVariable Integer Id_Libro, Model modelo) {
	        Libros libro = librosDao.findById(Id_Libro).orElse(null);
	        List<Autores> listaAutores = autoresDao.findAll();
	        List<Generos> listaGeneros = generosDao.findAll();

	        
	        modelo.addAttribute("listaAutores", listaAutores);
	        modelo.addAttribute("listaGeneros", listaGeneros);
	        
	        if (libro == null) {
	            return "redirect:/tablaLibros";
	        }

	        modelo.addAttribute("libro", libro);
	        return "nuevoLibro"; 
	   }

	@PostMapping("/editarLibro/{Id_Libro}")
	public String actualizarLibro(@PathVariable Integer Id_Libro, @Validated Libros libro, BindingResult bindingResult, RedirectAttributes redirect, Model modelo)  {
	        Libros libroDB = librosDao.findById(Id_Libro).orElse(null);
	        
	        if (libroDB == null) {
	            return "redirect:/tablaLibros";
	        }
	        if (bindingResult.hasErrors()) {
	            modelo.addAttribute("libro", libro);
	            return "nuevoLibro";
	        }
	        
	        libroDB.setISBN(libro.getISBN());
	        libroDB.setAutor(libro.getAutor());
	        libroDB.setGenero(libro.getGenero());
	        libroDB.setTitulo(libro.getTitulo());
	        libroDB.setExistencias(libro.getExistencias());
	        libroDB.setDisponibilidad(libro.getDisponibilidad());
	     
	        librosDao.save(libroDB);
	        redirect.addFlashAttribute("msgExito", "El libro ha sido actualizado con éxito.");
	        
	        
	        
	        return "redirect:/tablaLibros";
	    }

	@PostMapping("/eliminarLibro/{Id_Libro}")
		public String EliminarLibro(@PathVariable Integer Id_Libro, RedirectAttributes redirect) {
		   	Libros libro = librosDao.findById(Id_Libro).orElse(null);
		   	librosDao.delete(libro);
		   	redirect.addFlashAttribute("msgExito", "El libro ha sido eliminado con exito.");
		    return "redirect:/tablaLibros";
	    
	}
	
	@GetMapping(value = "/tablaLibros")
	public String tablaLibros(Model modelo){
		List<Libros> libros = librosDao.findAll();
		modelo.addAttribute("libros", libros);
		return "tablaLibros";
	}
	
	
	//endpoints para prestamos

	@GetMapping(value = "/nuevoPrestamo")
	public String nuevoPrestamo(Model modelo) {
	    List<Libros> listaLibros = librosDao.findAll();
	    List<Usuarios> listaUsuarios = usuariosDao.findAll();
	    List<Empleados> listaEmpleados = empleadosDao.findAll();

	    // Generar fecha del plazo (5 días después de la fecha actual)
	    String fechaPlazo = plazoService.generarFechaPlazo();

	    modelo.addAttribute("prestamo", new Prestamos());
	    modelo.addAttribute("listaLibros", listaLibros);
	    modelo.addAttribute("listaUsuarios", listaUsuarios);
	    modelo.addAttribute("listaEmpleados", listaEmpleados);
	    modelo.addAttribute("fechaPlazo", fechaPlazo);

	    return "nuevoPrestamo";
	}

	@PostMapping(value = "/guardarPrestamo")
	public String guardarPrestamo(@ModelAttribute("prestamo") @Valid Prestamos prestamo,BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
	    if (bindingResult.hasErrors()) {
	        List<Libros> listaLibros = librosDao.findAll();
	        List<Usuarios> listaUsuarios = usuariosDao.findAll();
	        List<Empleados> listaEmpleados = empleadosDao.findAll();

	        modelo.addAttribute("listaLibros", listaLibros);
	        modelo.addAttribute("listaUsuarios", listaUsuarios);
	        modelo.addAttribute("listaEmpleados", listaEmpleados);

	        return "nuevoPrestamo";
	    }

	    prestamo.setPlazo(LocalDateTime.now().plusDays(5));

	    prestamosDao.save(prestamo);
	    redirect.addFlashAttribute("msgExito", "El préstamo se ha registrado con éxito.");
	    return "redirect:/tablaPrestamos";
	}
	
	
	
	@GetMapping("/editarPrestamo/{Id_Prestamo}")
	public String editarPrestamo(@PathVariable Integer Id_Prestamo, Model modelo) {
	    Prestamos prestamo = prestamosDao.findById(Id_Prestamo).orElse(null);
	    List<Libros> listaLibros = librosDao.findAll();
	    List<Usuarios> listaUsuarios = usuariosDao.findAll();
	    List<Empleados> listaEmpleados = empleadosDao.findAll();

	    modelo.addAttribute("prestamo", prestamo); // Utiliza el objeto existente
	    modelo.addAttribute("listaLibros", listaLibros);
	    modelo.addAttribute("listaUsuarios", listaUsuarios);
	    modelo.addAttribute("listaEmpleados", listaEmpleados);

	    if (prestamo == null) {
	        return "redirect:/tablaPrestamos";
	    }

	    return "nuevoPrestamo";
	}

	@PostMapping("/editarPrestamo/{Id_Prestamo}")
	public String actualizarPrestamo(@PathVariable Integer Id_Prestamo, @Validated Prestamos prestamo, BindingResult bindingResult, RedirectAttributes redirect, Model modelo)  {
	        Prestamos prestamoDB = prestamosDao.findById(Id_Prestamo).orElse(null);
	        
	        if (prestamoDB == null) {
	            return "redirect:/tablaPrestamos";
	        }
	        if (bindingResult.hasErrors()) {
	            modelo.addAttribute("prestamo", prestamo);
	            return "nuevoPrestamo";
	        }
	        
	        prestamoDB.setLibro(prestamo.getLibro());
	        prestamoDB.setUsuario(prestamo.getUsuario());
	        prestamoDB.setEmpleado(prestamo.getEmpleado());
	        prestamoDB.setPlazo(prestamo.getPlazo());
	        prestamoDB.setFechaInicio(prestamo.getFechaInicio());
	     
	        prestamosDao.save(prestamoDB);
	        redirect.addFlashAttribute("msgExito", "El prestamo ha sido actualizado con éxito.");
	        return "redirect:/tablaPrestamos";
	    }

	@PostMapping("/eliminarPrestamo/{Id_Prestamo}")
		public String eliminarPrestamo(@PathVariable Integer Id_Prestamo, RedirectAttributes redirect) {
		   	Prestamos prestamo = prestamosDao.findById(Id_Prestamo).orElse(null);
		   	prestamosDao.delete(prestamo);
		   	redirect.addFlashAttribute("msgExito", "El prestamo ha sido eliminado con exito.");
		    return "redirect:/tablaPrestamos";
	    
	}
	
	@GetMapping(value = "/tablaPrestamos")
	public String tablaPrestamos(Model modelo){
		List<Prestamos> prestamos = prestamosDao.findAll();
		modelo.addAttribute("prestamos", prestamos);
		return "tablaPrestamos";
	}

}
