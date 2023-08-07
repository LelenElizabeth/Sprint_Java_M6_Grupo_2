package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Administrativo;
import cl.sprint.M6_Grupo2.modelos.repository.IAdministrativoRepository;

@Service
public class AdministrativoServicio {

	public AdministrativoServicio() {
		super();
	}
	
	@Autowired
	private IAdministrativoRepository AdmRepo;
	
	public ArrayList<Administrativo> obtenerAdministrativos(){
		return (ArrayList<Administrativo>) AdmRepo.findAll();
	}
	
	public Administrativo obtenerAdministrativo(int id) {
		return AdmRepo.findById(id).get();
	}
	
	public void crearAdministrativo(Administrativo Adm) {
		AdmRepo.save(Adm);
	}
	
	public void actualizar(Administrativo Adm) {
		AdmRepo.save(Adm);
	}
	
	public void borrarAdministrativo(int id) {
		AdmRepo.delete(AdmRepo.getOne(id));
	}
}
