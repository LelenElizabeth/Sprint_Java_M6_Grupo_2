package cl.sprint.M6_Grupo2.controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Administrativo;
import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.entity.Profesional;
import cl.sprint.M6_Grupo2.modelos.entity.RolUsuario;
import cl.sprint.M6_Grupo2.modelos.entity.Usuario;
import cl.sprint.M6_Grupo2.modelos.service.AdministrativoServicio;
import cl.sprint.M6_Grupo2.modelos.service.ClienteServicio;
import cl.sprint.M6_Grupo2.modelos.service.ProfesionalServicio;
import cl.sprint.M6_Grupo2.modelos.service.UsuarioServicio;


	@Controller
	public class UsuarioControlador {
		
		@Autowired
		private UsuarioServicio usu;
		@Autowired
		private ClienteServicio cliServ;
		@Autowired
		private ProfesionalServicio proServ;
		@Autowired
		private AdministrativoServicio adminServ;
		
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
		
		@RequestMapping(path = "/crear-usuario", method = RequestMethod.GET)
	    public ModelAndView mostrarInicio() {
	        return new ModelAndView("crearUsuario");
	    }
		
		@RequestMapping(path = "/crear-usuario", method = RequestMethod.POST)
	    public ModelAndView crearUsuario(@RequestParam("nombre") String nombre,
	            @RequestParam("contraseña") String contraseña,
	            @RequestParam("rol") String rol,
	            @RequestParam(value = "nombreCliente") String nombreCli,
	            @RequestParam(value = "nombreProfesional") String nombrePro,
	            @RequestParam(value = "nombreAdministrativo") String nombreAdmin,
	            @RequestParam(value = "apellidos") String apellidos,
	            @RequestParam(value = "edad") int edad,
	            @RequestParam(value = "rut") int rut,
	            @RequestParam(value = "telefono") int telefono,
	            @RequestParam(value = "direccion") String direccion,
	            @RequestParam(value = "comuna") String comuna,
	            @RequestParam(value = "area") String area,
	            @RequestParam(value = "experienciaPrevia") String experienciaPrevia,
	            @RequestParam(value = "titulo") String titulo,
	            @RequestParam(value = "fechaIngreso") String fecha) {
			
			DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate  fechaIngreso = LocalDate.parse(fecha,formatoOriginal);
	        // Encriptar la contraseña
	        String contraseñaEncriptada = passwordEncoder.encode(contraseña);
	        RolUsuario rolIng = null;
	        if(rol=="Cliente") {
	        	 rolIng = RolUsuario.Cliente;
	        }
	        if(rol=="Administrativo") {
	        	rolIng = RolUsuario.Administrativo; 
	        }
	        if(rol=="Profesional") {
	        	rolIng = RolUsuario.Profesional;
	        }
	        if (rolIng == RolUsuario.Cliente) {
	        	Cliente nuevoCliente = new Cliente(nombre, contraseñaEncriptada,nombreCli, apellidos, telefono, direccion, comuna, edad, rut);
	        	System.out.println(nuevoCliente);
	            usu.crearUsuario(nuevoCliente);
	        } else if (rolIng == RolUsuario.Administrativo) {
	            Administrativo nuevoAdmin = new Administrativo(nombre,contraseñaEncriptada,nombreAdmin,area,experienciaPrevia);
	        	System.out.println(nuevoAdmin);
	            usu.crearUsuario(nuevoAdmin);
	        } else if (rolIng == RolUsuario.Profesional) {
	            Profesional nuevoProfesional = new Profesional(nombre,contraseñaEncriptada,nombrePro,titulo,fechaIngreso);
	            System.out.println(nuevoProfesional);
	            usu.crearUsuario(nuevoProfesional);
	        }

	        return new ModelAndView("exito")
	                .addObject("mensaje", "El Usuario se ha creado correctamente.");
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
