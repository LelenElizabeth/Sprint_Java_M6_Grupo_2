package cl.sprint.M6_Grupo2.controladores;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Capacitacion;
import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.service.CapacitacionesServicio;
import cl.sprint.M6_Grupo2.modelos.service.ClienteServicio;


@Controller
public class CapacitacionesControlador {
	
	@Autowired
	private CapacitacionesServicio cap;
	
	@Autowired
	private ClienteServicio cliServ;
	
	@RequestMapping(value ="/ListarCapacitaciones",method = RequestMethod.GET)
	public ModelAndView listarCapacitaciones(ModelMap model) {
		ArrayList<Capacitacion> listaCapacitacion = new ArrayList<>();
		listaCapacitacion = cap.obtenerCapacitaciones();
		model.addAttribute("listaCapacitacion",listaCapacitacion);
		return new ModelAndView ("listar-capacitaciones",model);
	}
	@RequestMapping(path = "/crear-capacitacion", method = RequestMethod.GET)
    public ModelAndView mostrarInicio(ModelMap model) {
		List<Cliente>listadoClientes= cliServ.obtenerClientes();
		model.addAttribute("listadoClientes", listadoClientes);
        return new ModelAndView("crearCapacitacion",model);
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
		System.out.println(capacitacion);
		cap.crearCapacitacion(capacitacion);
		System.out.println(capacitacion);
		return new ModelAndView("crearCapacitacion")
	            .addObject("mensaje", "La Capacitacion se ha agregado correctamente.")
	            .addObject("mostrarAlert", true);
	}
}
