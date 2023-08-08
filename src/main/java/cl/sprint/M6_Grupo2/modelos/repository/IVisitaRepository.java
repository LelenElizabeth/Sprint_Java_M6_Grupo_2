package cl.sprint.M6_Grupo2.modelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sprint.M6_Grupo2.modelos.entity.Visitas;

public interface IVisitaRepository extends JpaRepository<Visitas,Integer> {

}
