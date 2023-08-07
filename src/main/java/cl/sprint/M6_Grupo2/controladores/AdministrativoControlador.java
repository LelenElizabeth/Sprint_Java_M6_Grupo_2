package cl.sprint.M6_Grupo2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.sprint.M6_Grupo2.modelos.entity.Administrativo;
import cl.sprint.M6_Grupo2.modelos.service.AdministrativoServicio;

import java.util.ArrayList;

@RestController
@RequestMapping("/Administrativos")
public class AdministrativoControlador {

    @Autowired
    private AdministrativoServicio administrativoServicio;

    @GetMapping
    public ArrayList<Administrativo> obtenerAdministrativos() {
        return administrativoServicio.obtenerAdministrativos();
    }

    @GetMapping("/{id}")
    public Administrativo obtenerAdministrativoPorId(@PathVariable int id) {
        return administrativoServicio.obtenerAdministrativo(id);
    }

    @PostMapping
    public void crearAdministrativo(@RequestBody Administrativo Administrativo) {
        administrativoServicio.crearAdministrativo(Administrativo);
    }

    @PutMapping("/{id}")
    public void actualizarAdministrativo(@PathVariable int id, @RequestBody Administrativo administrativo) {
        Administrativo AdministrativoExistente = administrativoServicio.obtenerAdministrativo(id);
        if (AdministrativoExistente != null) {
            administrativo.setId(id); // Aseguramos que el ID coincida
            administrativoServicio.actualizar(administrativo);
        }
    }

    @DeleteMapping("/{id}")
    public void borrarAdministrativo(@PathVariable int id) {
        administrativoServicio.borrarAdministrativo(id);
    }
}
