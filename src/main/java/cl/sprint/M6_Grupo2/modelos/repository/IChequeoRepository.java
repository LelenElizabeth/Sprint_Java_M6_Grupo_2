package cl.sprint.M6_Grupo2.modelos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sprint.M6_Grupo2.modelos.entity.Chequeo;

public interface IChequeoRepository extends JpaRepository<Chequeo,Integer>{
	List<Chequeo> findByVisitasId(int visitaId);
}
