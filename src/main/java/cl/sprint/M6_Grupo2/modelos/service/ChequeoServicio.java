package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Chequeo;
import cl.sprint.M6_Grupo2.modelos.entity.Visitas;
import cl.sprint.M6_Grupo2.modelos.repository.IChequeoRepository;
import cl.sprint.M6_Grupo2.modelos.repository.IVisitaRepository;

@Service
public class ChequeoServicio {

	@Autowired
	private IChequeoRepository chequeoRepo;
	
	@Autowired
	private IVisitaRepository visitaRepo;
	
	public ArrayList<Chequeo> obtenerChequeos() {
		return (ArrayList<Chequeo>) chequeoRepo.findAll();
	}
	
	@Transactional
	public ArrayList<Chequeo> obtenerChequeosPorId(int visitaId) {
	    ArrayList<Chequeo> listaChequeos = (ArrayList<Chequeo>)chequeoRepo.findByVisitasId(visitaId);
	    return listaChequeos;
	}

	public Chequeo obtenerChequeo(int id) {
		return chequeoRepo.findById(id).get();
	}

	public void crearChequeo(Chequeo pago) {
		chequeoRepo.save(pago);
	}

	public void actualizar(Chequeo pago) {
		chequeoRepo.save(pago);
	}

	public void borrarChequeo(int id) {
		chequeoRepo.delete(chequeoRepo.getOne(id));
	}
}
