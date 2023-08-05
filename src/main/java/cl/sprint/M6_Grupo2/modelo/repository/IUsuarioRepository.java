package cl.sprint.M6_Grupo2.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import  cl.sprint.M6_Grupo2.modelos.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{

}
