package cl.sprint.M6_Grupo2.controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Administrativo;
import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.entity.Profesional;
import cl.sprint.M6_Grupo2.modelos.entity.RolUsuario;
import cl.sprint.M6_Grupo2.modelos.entity.Usuario;
import cl.sprint.M6_Grupo2.modelos.service.ProfesionalServicio;
import cl.sprint.M6_Grupo2.modelos.service.UsuarioServicio;
import cl.sprint.M6_Grupo2.modelos.service.VisitasServicio;


	@Controller
	public class UsuarioControlador {

		@Autowired
		private UsuarioServicio usu;
		@Autowired
		private ProfesionalServicio usuPro;
		@Autowired
		private VisitasServicio visitaServ;
		
		@Autowired
	    private PasswordEncoder passwordEncoder;
		
		@RequestMapping(path = "/CrearUsuario", method = RequestMethod.GET)
	    public ModelAndView mostrarVista() {
	        return new ModelAndView("crear-usuario");
	    }
		
		@RequestMapping(value ="/ListadoUsuarios",method = RequestMethod.GET)
		public ModelAndView listarUsuarios() {
			ArrayList<Usuario> listarUsuarios = new ArrayList<>();
			listarUsuarios = usu.obtenerUsuarios();
			
			return new ModelAndView ("listado-usuarios","listarUsuarios",listarUsuarios);
		}
		
		@RequestMapping(value = "/EliminarUsuario")
	    public ModelAndView mostrarCliente(ModelMap model,
	            @RequestParam("idRescatado") int id) {
	        
	        usu.borrarUsuario(id);
	        model.addAttribute("mensaje", "Usuario eliminado con éxito");
	        return new ModelAndView("redirect:/ListadoUsuarios", model);
	    }
		
		@RequestMapping(path = "/crear-usuario", method = RequestMethod.GET)
	    public ModelAndView mostrarInicio() {
	        return new ModelAndView("crearUsuario");
	    }
		
		@RequestMapping(path = "/crear-profesional", method = RequestMethod.POST)
	    public ModelAndView crearUsuarioPro(@RequestParam("nombre") String nombre,
	            @RequestParam("contraseña") String contraseña,
	            @RequestParam("rol") RolUsuario rol,
	            @RequestParam(value = "nombreProfesional") String nombrePro,
	            @RequestParam(value = "titulo") String titulo,
	            @RequestParam(value = "fechaIngreso") String fecha) {
			DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate  fechaIngreso = LocalDate.parse(fecha,formatoOriginal);
	        
	        // Encriptar la contraseña
	        String contraseñaEncriptada = passwordEncoder.encode(contraseña);
            Profesional nuevoProfesional = new Profesional(nombre,contraseñaEncriptada,nombrePro,titulo,fechaIngreso);
            System.out.println(nuevoProfesional);
            usu.crearUsuario(nuevoProfesional);

	        return new ModelAndView("exito")
	                .addObject("mensaje", "El Usuario se ha creado correctamente.");
		}

		@RequestMapping(path = "/crear-administrativo", method = RequestMethod.POST)
	    public ModelAndView crearUsuarioAdmin(@RequestParam("nombre") String nombre,
	            @RequestParam("contraseña") String contraseña,
	            @RequestParam("rol") RolUsuario rol,
	            @RequestParam(value = "nombreAdministrativo") String nombreAdmin,
	            @RequestParam(value = "area") String area,
	            @RequestParam(value = "experienciaPrevia") String experienciaPrevia) {
			
	        // Encriptar la contraseña
	        String contraseñaEncriptada = passwordEncoder.encode(contraseña);
	        Administrativo nuevoAdmin = new Administrativo(nombre,contraseñaEncriptada,nombreAdmin,area,experienciaPrevia);
        	System.out.println(nuevoAdmin);
            usu.crearUsuario(nuevoAdmin);

	        return new ModelAndView("exito")
	                .addObject("mensaje", "El Usuario se ha creado correctamente.");
		}

		@RequestMapping(path = "/crear-cliente", method = RequestMethod.POST)
	    public ModelAndView crearUsuarioCli(@RequestParam("nombre") String nombre,
	            @RequestParam("contraseña") String contraseña,
	            @RequestParam("rol") RolUsuario rol,
	            @RequestParam(value = "nombreCliente") String nombreCli,
	            @RequestParam(value = "apellidos") String apellidos,
	            @RequestParam(value = "edad") int edad,
	            @RequestParam(value = "rut") int rut,
	            @RequestParam(value = "telefono") int telefono,
	            @RequestParam(value = "direccion") String direccion,
	            @RequestParam(value = "comuna") String comuna) {
			
	        // Encriptar la contraseña
	        String contraseñaEncriptada = passwordEncoder.encode(contraseña);
	        Cliente nuevoCliente = new Cliente(nombre, contraseñaEncriptada,nombreCli, apellidos, telefono, direccion, comuna, edad, rut);
        	System.out.println(nuevoCliente);
            usu.crearUsuario(nuevoCliente);

	        return new ModelAndView("exito")
	                .addObject("mensaje", "El Usuario se ha creado correctamente.");
		}
	}
