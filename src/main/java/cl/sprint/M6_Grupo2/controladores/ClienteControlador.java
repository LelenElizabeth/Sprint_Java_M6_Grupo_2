package cl.sprint.M6_Grupo2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.service.ClienteServicio;

import java.util.ArrayList;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public ArrayList<Cliente> obtenerClientes() {
        return clienteServicio.obtenerClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable int id) {
        return clienteServicio.obtenerCliente(id);
    }

    @PostMapping
    public void crearCliente(@RequestBody Cliente cliente) {
        clienteServicio.crearCliente(cliente);
    }

    @PutMapping("/{id}")
    public void actualizarCliente(@PathVariable int id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = clienteServicio.obtenerCliente(id);
        if (clienteExistente != null) {
            cliente.setId(id); // Aseguramos que el ID coincida
            clienteServicio.actualizar(cliente);
        }
    }

    @DeleteMapping("/{id}")
    public void borrarCliente(@PathVariable int id) {
        clienteServicio.borrarCliente(id);
    }
}
