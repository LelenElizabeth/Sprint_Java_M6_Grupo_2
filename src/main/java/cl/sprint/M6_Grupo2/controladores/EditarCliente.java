package cl.sprint.M6_Grupo2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.entity.Usuario;
import cl.sprint.M6_Grupo2.modelos.service.ClienteServicio;
import cl.sprint.M6_Grupo2.modelos.service.UsuarioServicio;

@Controller
public class EditarCliente {

    @Autowired
    private ClienteServicio cliServ;
    
    @Autowired
    private UsuarioServicio usuServ;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
    @RequestMapping(value = "/EditarCliente")
    public ModelAndView mostrarCliente(ModelMap model,
            @RequestParam("idRescatado") int id) {
        
        Cliente cli = cliServ.obtenerCliente(id);
        model.addAttribute("usuario", cli);
        return new ModelAndView("editar-usuario", model);
    }

    @RequestMapping(value = "/EditarCliente", method = RequestMethod.POST)
    public ModelAndView editarClient(
            @RequestParam("idUsuario")int id,
            @RequestParam("nombreUsuario") String nombreUsuario,
            @RequestParam("contraseña")String contrasena,
            @RequestParam("nombres") String nombres,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("telefono") int telefono,
            @RequestParam("direccion") String direccion,
            @RequestParam("comuna") String comuna,
            @RequestParam("edad") int edad,
            @RequestParam("rut") int rut) {
    	
    	//Validar nombre de usuario o contraseña nulas
    	Usuario usuPro =usuServ.obtenerUsuario(id);
        if(nombreUsuario.trim() == null || nombreUsuario.trim() == "") {
        	nombreUsuario = usuPro.getNombre();
        }
        if(contrasena.trim() == null|| contrasena.trim() == "") {
        	contrasena= usuPro.getContraseña();
        }else {
        	contrasena = passwordEncoder.encode(contrasena);
        }
       Cliente cliente = new Cliente(id, nombreUsuario, contrasena, nombres, apellidos, telefono, direccion, comuna, edad, rut);
       cliServ.actualizar(cliente);
       return new ModelAndView("exito")
               .addObject("mensaje", "Usuario modificado correctamente");
               
    }
}