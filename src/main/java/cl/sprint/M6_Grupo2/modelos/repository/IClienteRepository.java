package cl.sprint.M6_Grupo2.modelos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;



public interface IClienteRepository extends JpaRepository<Cliente,Integer>{
	Optional<Cliente> findByRut(int rut);
}
