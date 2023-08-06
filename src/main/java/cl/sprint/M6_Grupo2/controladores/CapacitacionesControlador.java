package cl.sprint.M6_Grupo2.controladores;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(path = "/crear-capacitacion", method = RequestMethod.GET)
    public ModelAndView mostrarInicio() {
        return new ModelAndView("crearCapacitacion");
    }
	
	@RequestMapping(path = "/crear-capacitacion", method = RequestMethod.POST)
    public ModelAndView crearCapacitacion(@RequestParam("nombre") String nombre, 
    		@RequestParam("detalle") String detalle, 
    		@RequestParam("rutCliente") int rutCliente,
    		@RequestParam("dia") String dia,
    		@RequestParam("hora") String hora,
    		@RequestParam("duracion") String duracion,
    		@RequestParam("lugar") String lugar,
    		@RequestParam("cantidadAsistentes") int cantidadAsistentes) {
		
		Capacitacion capacitacion = new Capacitacion(nombre,detalle,rutCliente,dia,hora,lugar,duracion,cantidadAsistentes);
		cap.crearCapacitacion(capacitacion);
		System.out.println(capacitacion);
		return new ModelAndView("crearCapacitacion")
	            .addObject("mensaje", "La Capacitacion se ha agregado correctamente.")
	            .addObject("mostrarAlert", true);
	}
}
