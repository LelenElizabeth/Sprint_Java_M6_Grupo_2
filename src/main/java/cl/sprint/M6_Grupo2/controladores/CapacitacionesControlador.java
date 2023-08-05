package cl.sprint.M6_Grupo2.controladores;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Capacitacion;
import cl.sprint.M6_Grupo2.modelos.service.CapacitacionesServicio;


@Controller
public class CapacitacionesControlador {
	
	@Autowired
	private CapacitacionesServicio cap;
	
	@RequestMapping(value ="/ListarCapacitaciones",method = RequestMethod.GET)
	public ModelAndView listarCapacitaciones() {
		ArrayList<Capacitacion> listaCapacitacion = new ArrayList<>();
		listaCapacitacion = cap.obtenerCapacitaciones();
		
		return new ModelAndView ("listar-capacitaciones","listaCapacitacion",listaCapacitacion);
	}
}
