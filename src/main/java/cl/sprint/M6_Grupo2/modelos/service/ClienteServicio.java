package cl.sprint.M6_Grupo2.modelos.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.repository.IClienteRepository;

@Service
public class ClienteServicio {

	public ClienteServicio() {
		super();
	}
	
	@Autowired
	private IClienteRepository cliRepo;
	
	public ArrayList<Cliente> obtenerClientes(){
		return (ArrayList<Cliente>) cliRepo.findAll();
	}
	
	public Cliente obtenerCliente(int id) {
		return cliRepo.findById(id).get();
	}
	public Cliente obtenerClientePorRut(int rut) {
        Optional<Cliente> clienteOptional = cliRepo.findByRut(rut);
        return clienteOptional.orElse(null); 
    }
	public void crearCliente(Cliente cli) {
		cliRepo.save(cli);
	}
	
	public void actualizar(Cliente cli) {
		cliRepo.save(cli);
	}
	
	public void borrarCliente(int id) {
		cliRepo.delete(cliRepo.getOne(id));
	}
}
