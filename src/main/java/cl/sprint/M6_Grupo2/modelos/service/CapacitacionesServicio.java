package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Capacitacion;
import cl.sprint.M6_Grupo2.modelos.repository.ICapacitacionesRepository;



@Service
public class CapacitacionesServicio {

	public CapacitacionesServicio() {
		super();
	}
	
	@Autowired
	private ICapacitacionesRepository capaRepo;
	
	public ArrayList<Capacitacion> obtenerCapacitaciones(){
		return (ArrayList<Capacitacion>) capaRepo.findAll();
	}
	
	public Capacitacion obtenerCapacitacion(int id) {
		return capaRepo.getOne(id);
	}
	
	public void crearCapacitacion(Capacitacion cap) {
		capaRepo.save(cap);
	}
	
	public void actualizar(Capacitacion cap) {
		capaRepo.save(cap);
	}
	
	public void borrarCapacitacion(int id) {
		capaRepo.delete(capaRepo.getOne(id));
	}

}
