package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Capacitacion;
import cl.sprint.M6_Grupo2.modelos.entity.Visitas;
import cl.sprint.M6_Grupo2.modelos.repository.ICapacitacionesRepository;
import cl.sprint.M6_Grupo2.modelos.repository.IVisitaRepository;



@Service
public class VisitasServicio {

	public VisitasServicio() {
		super();
	}
	
	@Autowired
	private IVisitaRepository visRepo;
	
	public ArrayList<Visitas> obtenerVisitas(){
		return (ArrayList<Visitas>) visRepo.findAll();
	}
	
	public Visitas obtenerVisitas(int id) {
		return visRepo.getOne(id);
	}
	
	public void crearVisitas(Visitas vis) {
		visRepo.save(vis);
	}
	
	public void actualizar(Visitas vis) {
		visRepo.save(vis);
	}
	
	public void borrarVisitas(int id) {
		visRepo.delete(visRepo.getOne(id));
	}

}
