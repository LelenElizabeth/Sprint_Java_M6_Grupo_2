package cl.sprint.M6_Grupo2.modelos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.sprint.M6_Grupo2.modelos.entity.Pago;

public interface IPagoRepository extends JpaRepository<Pago,Integer> {

}
