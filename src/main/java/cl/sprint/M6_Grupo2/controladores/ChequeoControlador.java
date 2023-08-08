package cl.sprint.M6_Grupo2.controladores;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Chequeo;
import cl.sprint.M6_Grupo2.modelos.entity.Estado;
import cl.sprint.M6_Grupo2.modelos.entity.Visitas;
import cl.sprint.M6_Grupo2.modelos.service.ChequeoServicio;

@Controller
public class ChequeoControlador {
	
	@Autowired
	private ChequeoServicio cheqServ;
	
	@RequestMapping(value ="/responder-checklist", method = RequestMethod.GET)
	public ModelAndView listaChequeos(@RequestParam("visitaId") int visitaId) {
		System.out.println(visitaId);
		ArrayList<Chequeo> listaChequeos = new ArrayList<>();
		listaChequeos = cheqServ.obtenerChequeosPorId(visitaId);
		
		return new ModelAndView ("checklist-visitas")
				.addObject("listaChequeos",listaChequeos)
				.addObject("visitaId",visitaId);
	}
	
	@RequestMapping(path = "/crear-chequeo", method = RequestMethod.POST)
	public ModelAndView crearChequeos(HttpServletRequest request) {
		int visitaId;
		try {
			visitaId = Integer.parseInt(request.getParameter("visitaId"));
		} catch (Exception e) {
			return new ModelAndView("error").addObject("mensaje","Error al hacer Integer.parseInt a visitaId"
					+ " en ChequeoControlador desde checklist-visitas.jsp");
		}
	    String[] detalles = request.getParameterValues("detalle");

	    if (detalles != null && detalles.length > 0) {
	        for (String detalle : detalles) {
	            if (!detalle.isEmpty()) {
	                Chequeo nuevoChequeo = new Chequeo();
	                Visitas visit = new Visitas();
	                visit.setId(visitaId);
	                nuevoChequeo.setVisita(visit);
	                nuevoChequeo.setDetalle(detalle);
	                nuevoChequeo.setEstado(Estado.Pendiente); 
	                cheqServ.crearChequeo(nuevoChequeo);
	            }
	        }
	    } else {
	        // Manejar el caso cuando no se proporcionan detalles
	        // Puede mostrar un mensaje de error o redirigir a alguna otra vista
	        return new ModelAndView("error").addObject("mensaje", "No se proporcionaron detalles para crear chequeos");
	    }

	    return new ModelAndView("redirect:/responder-checklist").addObject("visitaId",visitaId);
	}
}
