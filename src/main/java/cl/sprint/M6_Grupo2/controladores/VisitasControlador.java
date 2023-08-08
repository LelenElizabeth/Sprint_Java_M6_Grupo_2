/**
 * 
 */
package cl.sprint.M6_Grupo2.controladores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.entity.Profesional;
import cl.sprint.M6_Grupo2.modelos.entity.Visitas;
import cl.sprint.M6_Grupo2.modelos.service.ClienteServicio;
import cl.sprint.M6_Grupo2.modelos.service.ProfesionalServicio;
import cl.sprint.M6_Grupo2.modelos.service.VisitasServicio;

@Controller
public class VisitasControlador {

	@Autowired
	private VisitasServicio vis;

	@Autowired
	private ProfesionalServicio prof;

	@Autowired
	private ClienteServicio cliServ;

	@RequestMapping(value = "/ListadoVisitas", method = RequestMethod.GET)
	public ModelAndView listaVisitas() {
		ArrayList<Visitas> listaVisitas = new ArrayList<>();
		listaVisitas = vis.obtenerVisitas();

		return new ModelAndView("listado-de-visitas", "listaVisitas", listaVisitas);
	}

	@RequestMapping(path = "/crear-visita", method = RequestMethod.GET)
	public ModelAndView mostrarVista(ModelMap model) {
		List<Cliente> listaClientes = cliServ.obtenerClientes();
		model.addAttribute("listaClientes", listaClientes);

		List<Profesional> profesionales = prof.obtenerProfesional();
		model.addAttribute("profesionales", profesionales);
		return new ModelAndView("crear-visita", model);
	}

	@RequestMapping(value="crear-visita",method = RequestMethod.POST)
	public ModelAndView crearVisita(
			@RequestParam("cliente_rut") int cliente_rut,
			@RequestParam("profesional_id") int profesional_id,
			@RequestParam("fecha")String fecha,
			@RequestParam("lugar") String lugar,
			@RequestParam("comentarios")String comentarios){
		Profesional profesional = prof.obtenerProfesional(profesional_id);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fecha_hora = LocalDateTime.parse(fecha, formatter);
        Cliente cliente = cliServ.obtenerClientePorRut(cliente_rut);
        
        Visitas visita= new Visitas(cliente,fecha_hora,lugar,comentarios, profesional);
		vis.crearVisitas(visita);
        
        return new ModelAndView("crear-visita")
        		.addObject("mensaje","La visita se ha creado correctamente.")
        		.addObject("mostrarAlert", true);
        		
	}
}
