/**
 * 
 */
package cl.sprint.M6_Grupo2.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Visitas;
import cl.sprint.M6_Grupo2.modelos.service.VisitasServicio;


@Controller
public class VisitasControlador {
	
	@Autowired
	private VisitasServicio vis;

	@RequestMapping(value ="/ListadoVisitas",method = RequestMethod.GET)
	public ModelAndView listaVisitas() {
		ArrayList<Visitas> listaVisitas = new ArrayList<>();
		listaVisitas = vis.obtenerVisitas();
		
		return new ModelAndView ("listado-de-visitas","listaVisitas",listaVisitas);
	}
	
	@RequestMapping(path = "/CrearVisita", method = RequestMethod.GET)
    public ModelAndView mostrarVista() {
        return new ModelAndView("crearVisita");
    }
	

}
