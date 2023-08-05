package cl.sprint.M6_Grupo2.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.sprint.M6_Grupo2.modelos.entity.Capacitacion;
import cl.sprint.M6_Grupo2.modelos.service.CapacitacionesServicio;

@RestController
public class RestCapacitacionesControlador {

	@Autowired
	private CapacitacionesServicio cap;
	
	
	//metotodo para obtener todas capacitaciones
	@RequestMapping(value="/api/capacitaciones",headers="Accept=application/json")
	public ArrayList<Capacitacion> getCapacitaciones(){
		return cap.obtenerCapacitaciones();
	}
	
	//metodo para obtener una capacitacion en especifico
	@RequestMapping(value="/api/capacitaciones/{id}", headers="Accept=application/json")
	public Capacitacion getCapacitacion(@PathVariable("id") int id) {
		return cap.obtenerCapacitacion(id);
	}

	//metodo para crear una capacitacion

	@PostMapping(value="/api/capacitaciones", headers="Accept=application/json")
	public void crearCapacitacion(@RequestBody Capacitacion capacitacion){
		System.out.println(capacitacion.getCantidadAsistentes());
		System.out.println(capacitacion.getRutCliente());

		
		cap.crearCapacitacion(capacitacion);
	
		
	}
}
