package cl.sprint.M6_Grupo2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactoControlador {

	@RequestMapping(path = "/Contacto", method = RequestMethod.GET)
    public ModelAndView mostrarInicio() {
        return new ModelAndView("contacto");
    }
	@RequestMapping(path = "/Contacto", method = RequestMethod.POST)
    public ModelAndView procesarFormulario(@RequestParam("nombre") String nombre,
    		@RequestParam("email") String email,
    		@RequestParam("mensaje") String mensaje) {
		System.out.println("Contacto recibido: \n Nombre: "+ nombre
				+ "\n Email: " + email + "\n Mensaje: " + mensaje);
        return new ModelAndView("exito", "mensaje", "Hemos recibido tu mensaje, te contactaremos al correo proporcionado.");
    }
}
