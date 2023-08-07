package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Profesional;
import cl.sprint.M6_Grupo2.modelos.repository.IProfesionalRepository;

@Service
public class ProfesionalServicio {

	public ProfesionalServicio() {
		super();
	}
	
	@Autowired
	private IProfesionalRepository proRepo;
	
	public ArrayList<Profesional> obtenerProfesional(){
		return (ArrayList<Profesional>) proRepo.findAll();
	}
	
	public Profesional obtenerProfesional(int id) {
		return proRepo.findById(id).get();
	}
	
	public void crearProfesional(Profesional pro) {
		proRepo.save(pro);
	}
	
	public void actualizar(Profesional pro) {
		proRepo.save(pro);
	}
	
	public void borrarProfesional(int id) {
		proRepo.delete(proRepo.getOne(id));
	}
}
