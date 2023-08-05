package cl.sprint.M6_Grupo2.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.sprint.M6_Grupo2.modelos.entity.Usuario;
import cl.sprint.M6_Grupo2.modelos.service.UsuarioServicio;



@RestController
public class RestUsuarioControlador{
	
	@Autowired
	private UsuarioServicio usu;
	
	@RequestMapping(value="/api/usuarios",headers="Accept=application/json")
	public ArrayList<Usuario> getUsuarios(){
	return usu.obtenerUsuarios();
	}
	@RequestMapping(value="/api/usuarios/{id}", headers="Accept=application/json")
	public Usuario getUsuario(@PathVariable("id") int id){
		return usu.obtenerUsuario(id);
	}
}
	