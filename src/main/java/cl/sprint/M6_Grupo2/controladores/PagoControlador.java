package cl.sprint.M6_Grupo2.controladores;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Cliente;
import cl.sprint.M6_Grupo2.modelos.entity.Pago;
import cl.sprint.M6_Grupo2.modelos.service.PagoServicio;

@Controller
public class PagoControlador {

	@Autowired
	private PagoServicio pago;
	
	@RequestMapping(value ="/lista-pagos",method = RequestMethod.GET)
	public ModelAndView listarPago() {
		ArrayList<Pago> listaPago = new ArrayList<>();
		listaPago = pago.obtenerPagos();
		
		return new ModelAndView ("lista-pago-clientes","listaPagos",listaPago);
	}
	
	@RequestMapping(value ="/crear-pago",method = RequestMethod.GET)
	public ModelAndView cargarWeb(){
		return new ModelAndView("crear-pago");
		
	}
	
	@RequestMapping(value ="/crear-pago",method = RequestMethod.POST)
	public ModelAndView crearPago(
			@RequestParam("cliente_id") int cliente_id,
			@RequestParam("monto") float monto,
			@RequestParam("fecha") String fechaPago){
		Cliente cli = new Cliente();
		cli.setId(cliente_id);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fechaHora = LocalDateTime.parse(fechaPago, formatter);
		Pago pag = new Pago(cli,monto,fechaHora);
		pago.crearPago(pag);
		return new ModelAndView("crear-pago")
	            .addObject("mensaje", "El Pago se ha agregado correctamente.")
	            .addObject("mostrarAlert", true);
	}
}