package cl.sprint.M6_Grupo2.controladores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.entity.Pago;
import cl.sprint.M6_Grupo2.modelos.service.ClienteServicio;
import cl.sprint.M6_Grupo2.modelos.service.PagoServicio;

@Controller
public class PagoControlador {

	@Autowired
	private PagoServicio pago;
	@Autowired
	private ClienteServicio cliServ;
	
	@RequestMapping(value ="/lista-pagos",method = RequestMethod.GET)
	public ModelAndView listarPago() {
		ArrayList<Pago> listaPago = new ArrayList<>();
		listaPago = pago.obtenerPagos();
		for (Pago pago : listaPago) {
	        Cliente cliente = cliServ.obtenerCliente(pago.getCliente().getId()); 
	        pago.setCliente(cliente);
	    }
		return new ModelAndView ("lista-pago-clientes","listaPagos",listaPago);
	}
	
	@RequestMapping(value = "/crear-pago", method = RequestMethod.GET)
	public ModelAndView cargarWeb(ModelMap model) {
	    List<Cliente> clientes = cliServ.obtenerClientes();
	    model.addAttribute("clientes", clientes);
	    return new ModelAndView("crear-pago", model);
	}
	
	@RequestMapping(value ="/crear-pago",method = RequestMethod.POST)
	public ModelAndView crearPago(
			@RequestParam("cliente_id") int cliente_id,
			@RequestParam("monto") float monto,
			@RequestParam("fecha") String fechaPago){
		Cliente cli = cliServ.obtenerCliente(cliente_id);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fechaHora = LocalDateTime.parse(fechaPago, formatter);
		Pago nuevoPago = new Pago(cli,monto,fechaHora);
		pago.crearPago(nuevoPago);
		return new ModelAndView("crear-pago")
	            .addObject("mensaje", "El Pago se ha agregado correctamente.")
	            .addObject("mostrarAlert", true);
	}
}