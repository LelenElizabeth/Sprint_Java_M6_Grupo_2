package cl.sprint.M6_Grupo2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.sprint.M6_Grupo2.modelos.entity.Profesional;
import cl.sprint.M6_Grupo2.modelos.service.ProfesionalServicio;

import java.util.ArrayList;

@RestController
@RequestMapping("/Profesional")
public class ProfesionalControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @GetMapping
    public ArrayList<Profesional> obtenerProfesionals() {
        return profesionalServicio.obtenerProfesional();
    }

    @GetMapping("/{id}")
    public Profesional obtenerProfesionalPorId(@PathVariable int id) {
        return profesionalServicio.obtenerProfesional(id);
    }

    @PostMapping
    public void crearProfesional(@RequestBody Profesional profesional) {
        profesionalServicio.crearProfesional(profesional);
    }

    @PutMapping("/{id}")
    public void actualizarProfesional(@PathVariable int id, @RequestBody Profesional profesional) {
        Profesional ProfesionalExistente = profesionalServicio.obtenerProfesional(id);
        if (ProfesionalExistente != null) {
            profesional.setId(id); // Aseguramos que el ID coincida
            profesionalServicio.actualizar(profesional);
        }
    }

    @DeleteMapping("/{id}")
    public void borrarProfesional(@PathVariable int id) {
        profesionalServicio.borrarProfesional(id);
    }
}
