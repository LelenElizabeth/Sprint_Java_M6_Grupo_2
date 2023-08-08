package cl.sprint.M6_Grupo2.controladores;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.RolUsuario;
import cl.sprint.M6_Grupo2.modelos.entity.Usuario;
import cl.sprint.M6_Grupo2.modelos.service.UsuarioServicio;


	@Controller
	public class UsuarioControlador {
		
		@Autowired
		private UsuarioServicio usu;
		
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
		        @RequestParam("rol") RolUsuario rol) {
		    

		    Usuario usuario = new Usuario(nombre, contraseña, rol);
		    usu.crearUsuario(usuario);
		    
		    System.out.println(usuario);
		    
		    return new ModelAndView("exito")
		            .addObject("mensaje", "El Usuario se ha creado correctamente.");
		}

	}
