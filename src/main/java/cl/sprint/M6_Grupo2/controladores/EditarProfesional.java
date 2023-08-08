package cl.sprint.M6_Grupo2.controladores;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.sprint.M6_Grupo2.modelos.entity.Profesional;
import cl.sprint.M6_Grupo2.modelos.service.ProfesionalServicio;

@Controller
public class EditarProfesional {

    @Autowired
    private ProfesionalServicio proServ;

    @RequestMapping(value = "/EditarProfesional")
    public ModelAndView mostrarProf(ModelMap model,
            @RequestParam("idRescatado") int id) {

        Profesional pro = proServ.obtenerProfesional(id);
        model.addAttribute("usuario", pro);
        return new ModelAndView("editar-usuario", model);
    }

    @RequestMapping(value = "/EditarProfesional", method = RequestMethod.POST)
    public ModelAndView editarProf(
            @RequestParam("idUsuario") int id,
            @RequestParam("nombreUsuario") String nombreUsuario,
            @RequestParam("contraseña") String contrasena,
            @RequestParam("nombre") String nombre,
            @RequestParam("titulo") String titulo,
            @RequestParam("fechaIngreso") LocalDate fecha) {
       
        DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate  fechaIngreso = LocalDate.parse(fecha.format(formatoOriginal));
        
        

        Profesional profesional = new Profesional(id, nombreUsuario, contrasena, nombre, titulo, fechaIngreso);
        System.out.println(profesional);
        proServ.actualizar(profesional);
        return new ModelAndView("exito")
          .addObject("mensaje", "Usuario modificado correctamente");

    }
    
}