package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Pago;
import cl.sprint.M6_Grupo2.modelos.repository.IPagoRepository;

@Service
public class PagoServicio {

	@Autowired
	private IPagoRepository pagoRepo;
	
	public ArrayList<Pago> obtenerPagos() {
		return (ArrayList<Pago>) pagoRepo.findAll();
	}

	public Pago obtenerPago(int id) {
		return pagoRepo.findById(id).get();
	}

	public void crearPago(Pago pago) {
		pagoRepo.save(pago);
	}

	public void actualizar(Pago pago) {
		pagoRepo.save(pago);
	}

	public void borrarPago(int id) {
		pagoRepo.delete(pagoRepo.getOne(id));
	}
}